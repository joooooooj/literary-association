-- noinspection SqlDialectInspectionForFile

INSERT INTO `paymentconcentrator`.`users` (`type`, `id`, `password`, `username`) VALUES ('ADMIN', '1', '$2a$10$perBHa7ac8GAUllOFTH46elUbG6ZLjs6VJFOu2mqm.knQLDIM8Asm', 'igor');

INSERT INTO `paymentconcentrator`.`role` (`id`, `name`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `paymentconcentrator`.`role` (`id`, `name`) VALUES ('2', 'ROLE_SUBSCRIBER');

INSERT INTO `paymentconcentrator`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');

INSERT INTO `paymentconcentrator`.`permission` (`id`, `name`) VALUES ('1', 'APPROVE_REQUEST');
INSERT INTO `paymentconcentrator`.`permission` (`id`, `name`) VALUES ('2', 'DECLINE_REQUEST');
INSERT INTO `paymentconcentrator`.`permission` (`id`, `name`) VALUES ('3', 'READ_REQUESTS');

INSERT INTO `paymentconcentrator`.`role_permission` (`role_id`, `permission_id`) VALUES ('1', '1');
INSERT INTO `paymentconcentrator`.`role_permission` (`role_id`, `permission_id`) VALUES ('1', '2');
INSERT INTO `paymentconcentrator`.`role_permission` (`role_id`, `permission_id`) VALUES ('1', '3');

INSERT INTO `paymentconcentrator`.`payment_method` (`id`, `name`) VALUES ('1', 'Bank');
INSERT INTO `paymentconcentrator`.`payment_method` (`id`, `name`) VALUES ('2', 'PayPal');
INSERT INTO `paymentconcentrator`.`payment_method` (`id`, `name`) VALUES ('3', 'Bitcoin');

INSERT INTO `paymentconcentrator`.`subscription_request` (`id`, `email`, `organization_description`, `organization_name`) VALUES ('1', 'lu@gmail.com', 'We sell books', 'LU');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('1', '1');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('1', '2');

INSERT INTO `paymentconcentrator`.`subscription_request` (`id`, `email`, `organization_description`, `organization_name`) VALUES ('2', 'lu2@gmail.com', 'We sell books2', 'LU2');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('2', '1');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('2', '3');

INSERT INTO `paymentconcentrator`.`subscription_request` (`id`, `email`, `organization_description`, `organization_name`) VALUES ('3', 'lu3@gmail.com', 'We sell books3', 'LU3');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('3', '1');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('3', '2');
INSERT INTO `paymentconcentrator`.`subscription_requests_payment_methods` (`request_id`, `payment_method_id`) VALUES ('3', '3');
