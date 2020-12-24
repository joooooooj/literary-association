INSERT INTO `banka`.`clients` (`address`, `name`, `surname`) VALUES ('Petra Drapsina 32, Novi Sad', 'Mile', 'Milic');
INSERT INTO `banka`.`clients` (`address`, `name`, `surname`) VALUES ('Puskinova 8, Novi Sad', 'Ana', 'Antic');

INSERT INTO `banka`.`accounts` (`account_number`, `balance`, `client_id`) VALUES ('535123456789666666', '1000', 1);
INSERT INTO `banka`.`accounts` (`account_number`, `balance`) VALUES ('535123456789333333', '1000');

INSERT INTO `banka`.`cards` (`cardholder_name`, `expire_date`, `pan`, `security_code`, `account_id`) VALUES ('MILE MILIC', '12/20', '5125353412341111', '123', 1);

INSERT INTO `banka`.`merchants` (`account_id`,`password`, `company_name`, `address`) VALUES (2, '$2a$10$perBHa7ac8GAUllOFTH46elUbG6ZLjs6VJFOu2mqm.knQLDIM8Asm', 'Vulkan DOO', 'Puskinova 8, Novi Sad');

INSERT INTO `banka`.`payments` (`amount`, `merchant_order_id`, `merchant_timestamp`, `merchant_id`) VALUES ('1000', '2', '2019-04-28 12:45:15.000000', '1');