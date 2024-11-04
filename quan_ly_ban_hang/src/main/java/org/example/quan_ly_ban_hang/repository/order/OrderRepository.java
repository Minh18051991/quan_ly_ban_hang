package org.example.quan_ly_ban_hang.repository.order;

import org.example.quan_ly_ban_hang.DTO.OrderDTO;

import org.example.quan_ly_ban_hang.DTO.ProductDetailDTO;
import org.example.quan_ly_ban_hang.model.Order;
import org.example.quan_ly_ban_hang.repository.BaseRepository;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class OrderRepository implements IOrderRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_ORDER = " SELECT ob.id ,customer.name,ob.order_date,ob.status,ob.is_deleted FROM order_bill ob left join  account on account.id = ob.account_id left join customer  on account.customer_id = customer.id where ob.is_deleted = false";
    private static final String APPROVE_ORDER = "update order_bill set status = false where id =?";
    private static final String DELETE_ORDER = "update order_bill set is_deleted = true where id =?";
    private static final String SELECT_ORDER_BY_NAME = "call get_order_by_name(?)";
    private static final String SELECT_PRODUCT_DETAIL = "call get_product_detail(?)";
    private static final String SELECT_EMAIL = "select * from order_status_changes";

    public OrderRepository() {
    }

    @Override
    public void add(Order order) {

    }

    @Override
    public void delete(int id) {
        try (Connection connection = baseRepository.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public List<OrderDTO> findByName(String name) {
        List<OrderDTO> orders = new ArrayList();
        OrderDTO order = null;
        try (Connection connection = baseRepository.getConnectDB()) {
            CallableStatement callableStatement = connection.prepareCall(SELECT_ORDER_BY_NAME);
            callableStatement.setString(1, name);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String accountId = resultSet.getString("name");
                Date orderDate = resultSet.getDate("order_date");
                boolean status = resultSet.getBoolean("status");
                boolean isDelete = resultSet.getBoolean("is_deleted");
                order = new OrderDTO(id, accountId, orderDate, status, isDelete);
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<OrderDTO> findAll() {
        List<OrderDTO> orders = new ArrayList<>();
        try (Connection connection = baseRepository.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String accountName = resultSet.getString("name");
                Date orderDate = resultSet.getDate("order_date");
                boolean status = resultSet.getBoolean("status");
                boolean isDelete = resultSet.getBoolean("is_deleted");
                OrderDTO order = new OrderDTO(id, accountName, orderDate, status, isDelete);
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public List<ProductDetailDTO> getProductDetail(int orderId) {
        List<ProductDetailDTO> productDetails = new ArrayList<>();
        ProductDetailDTO productDetail = null;
        try (Connection connection = baseRepository.getConnectDB()) {
            CallableStatement callableStatement = connection.prepareCall(SELECT_PRODUCT_DETAIL);
            callableStatement.setInt(1, orderId);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String productName = resultSet.getString("product_name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String imageUrl = resultSet.getString("image");
                int quantity = resultSet.getInt("quantity");
                productDetail = new ProductDetailDTO(productName, description, price, imageUrl, quantity);
                productDetails.add(productDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return productDetails;
    }

    public void approveOrder(int orderId) {
        try (Connection connection = baseRepository.getConnectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(APPROVE_ORDER);
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // phương thức gửi email
    public void sendEmail(String toEmail, String subject, String messageText) {
        String fromEmail = "hungnguuen988@gmail.com"; // Địa chỉ email gửi
        String password = "lutgmghgtijcsgbc"; // Mật khẩu email

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    // Phương thức kiểm tra bảng thay đổi và gửi email
    public void checkStatusChanges() {


        try (Connection connection = baseRepository.getConnectDB()) {


            PreparedStatement stmt = connection.prepareStatement(SELECT_EMAIL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int invoiceId = rs.getInt("order_id");
                String newStatus = rs.getString("new_status");
                String customerEmail = rs.getString("customer_email");

                // Gửi email thông báo
                String subject = "Cập nhật trạng thái hóa đơn #" + invoiceId;
                String message = "Trạng thái hóa đơn của bạn đã được cập nhật thành: " + newStatus;
                sendEmail(customerEmail, subject, message);
            }

            // Sau khi gửi email, có thể xóa các bản ghi đã gửi (tùy chọn)
            stmt.executeUpdate("DELETE FROM order_status_changes");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
