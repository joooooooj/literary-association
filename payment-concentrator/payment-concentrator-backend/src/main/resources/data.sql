INSERT INTO `paymentconcentrator`.`role` (`id`, `name`) VALUES ('1', 'ROLE_ADMIN');

INSERT INTO `paymentconcentrator`.`users` (`type`, `id`, `password`, `username`) VALUES ('ADMIN', '1', '$2a$10$perBHa7ac8GAUllOFTH46elUbG6ZLjs6VJFOu2mqm.knQLDIM8Asm', 'igor');

INSERT INTO `paymentconcentrator`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
