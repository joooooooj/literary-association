-- noinspection SqlDialectInspectionForFile

INSERT INTO `paymentconcentrator`.`users` (`type`, `id`, `password`, `username`) VALUES ('ADMIN', '1', '$2a$10$perBHa7ac8GAUllOFTH46elUbG6ZLjs6VJFOu2mqm.knQLDIM8Asm', 'igor');

INSERT INTO `paymentconcentrator`.`role` (`id`, `name`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `paymentconcentrator`.`role` (`id`, `name`) VALUES ('2', 'ROLE_SUBSCRIBER');

INSERT INTO `paymentconcentrator`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');

INSERT INTO `paymentconcentrator`.`permission` (`id`, `name`) VALUES ('1', 'APPROVE_REQUEST');
INSERT INTO `paymentconcentrator`.`permission` (`id`, `name`) VALUES ('2', 'DECLINE_REQUEST');
INSERT INTO `paymentconcentrator`.`permission` (`id`, `name`) VALUES ('3', 'READ_REQUESTS');
INSERT INTO `paymentconcentrator`.`permission` (`id`, `name`) VALUES ('4', 'CREATE_PAYMENT_METHOD');
INSERT INTO `paymentconcentrator`.`permission` (`id`, `name`) VALUES ('5', 'DELETE_PAYMENT_METHOD');
INSERT INTO `paymentconcentrator`.`permission` (`id`, `name`) VALUES ('6', 'INITIATE_PAYMENT');

INSERT INTO `paymentconcentrator`.`role_permission` (`role_id`, `permission_id`) VALUES ('1', '1');
INSERT INTO `paymentconcentrator`.`role_permission` (`role_id`, `permission_id`) VALUES ('1', '2');
INSERT INTO `paymentconcentrator`.`role_permission` (`role_id`, `permission_id`) VALUES ('1', '3');
INSERT INTO `paymentconcentrator`.`role_permission` (`role_id`, `permission_id`) VALUES ('1', '4');
INSERT INTO `paymentconcentrator`.`role_permission` (`role_id`, `permission_id`) VALUES ('1', '5');
INSERT INTO `paymentconcentrator`.`role_permission` (`role_id`, `permission_id`) VALUES ('2', '6');

INSERT INTO `paymentconcentrator`.`payment_method` (`id`, `name`) VALUES ('1', 'Bank');
INSERT INTO `paymentconcentrator`.`payment_method` (`id`, `name`) VALUES ('2', 'PayPal');
INSERT INTO `paymentconcentrator`.`payment_method` (`id`, `name`) VALUES ('3', 'Bitcoin');

INSERT INTO `paymentconcentrator`.`subscription_request` (`id`, `organization_email`, `organization_description`, `organization_name`) VALUES ('1', 'lu@gmail.com', 'We sell books', 'LU');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('1', '1');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('1', '2');

INSERT INTO `paymentconcentrator`.`subscription_request` (`id`, `organization_email`, `organization_description`, `organization_name`) VALUES ('2', 'lu2@gmail.com', 'We sell books2', 'LU2');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('2', '1');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('2', '3');

INSERT INTO `paymentconcentrator`.`subscription_request` (`id`, `organization_email`, `organization_description`, `organization_name`) VALUES ('3', 'lu3@gmail.com', 'We sell books3', 'LU3');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('3', '1');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('3', '2');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('3', '3');

-- ############## Inserting generic subscriber ###################### --
INSERT INTO `paymentconcentrator`.`subscriber_details` (`id`, `merchant_error_url`, `merchant_failed_url`, `merchant_id`, `merchant_password`, `merchant_success_url`) VALUES ('1', 'http://localhost:3000/error', 'http://localhost:3000/failed', '1', '$2a$10$perBHa7ac8GAUllOFTH46elUbG6ZLjs6VJFOu2mqm.knQLDIM8Asm', 'http://localhost:3000/success');
INSERT INTO `paymentconcentrator`.`subscriber_details` (`id`, `merchant_error_url`, `merchant_failed_url`, `merchant_id`, `merchant_password`, `merchant_success_url`) VALUES ('2', 'http://localhost:3000/error', 'http://localhost:3000/failed', '2', '$2a$10$perBHa7ac8GAUllOFTH46elUbG6ZLjs6VJFOu2mqm.knQLDIM8Asm', 'http://localhost:3000/success');

INSERT INTO `paymentconcentrator`.`users` (`type`, `id`, `email`, `password`, `username`, `subscriber_details_id`, `client_id`, `client_secret`) VALUES ('SUBSCRIBER', '2', 'vulkan@gmail.com', '$2a$10$perBHa7ac8GAUllOFTH46elUbG6ZLjs6VJFOu2mqm.knQLDIM8Asm', 'vulkan', '1', '1333c2b2-6193-4751-971f-5c04985bb108', 'vhpnZmgEzvB9t8O88j0jNOFDXZZ0Fjv9xqCJfC8n');
INSERT INTO `paymentconcentrator`.`users` (`type`, `id`, `email`, `password`, `username`, `subscriber_details_id`) VALUES ('SUBSCRIBER', '3', 'delfi@gmail.com', '$2a$10$perBHa7ac8GAUllOFTH46elUbG6ZLjs6VJFOu2mqm.knQLDIM8Asm', 'delfi', '2');

INSERT INTO `paymentconcentrator`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `paymentconcentrator`.`user_roles` (`user_id`, `role_id`) VALUES ('3', '2');

INSERT INTO `paymentconcentrator`.`subscriptions` (`subscriber_id`, `payment_method_id`) VALUES ('2','1');
INSERT INTO `paymentconcentrator`.`subscriptions` (`subscriber_id`, `payment_method_id`) VALUES ('3','1');
