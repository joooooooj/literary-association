INSERT INTO `banka`.`clients` (`address`, `name`, `surname`) VALUES ('Petra Drapsina 32, Novi Sad', 'Mile', 'Milic');
INSERT INTO `banka`.`clients` (`address`, `name`, `surname`) VALUES ('Puskinova 8, Novi Sad', 'Ana', 'Antic');

INSERT INTO `banka`.`accounts` (`id`, `account_number`, `balance`, `client_id`) VALUES ('1', '1223344322', '100', '1');
INSERT INTO `banka`.`accounts` (`id`, `account_number`, `balance`, `client_id`) VALUES ('2', '2332332332', '20', '2');

INSERT INTO `banka`.`merchants` (`id`, `address`, `company_name`, `password`, `account_id`) VALUES ('1', 'Puskinova 10, Novi Sad', 'Udruzenje', '123123', '1');

INSERT INTO `banka`.`payments` (`id`, `amount`, `merchant_order_id`, `merchant_timestamp`, `merchant_id`) VALUES ('1', '20', '1', '2017-01-13T17:09:42.411', '1');

INSERT INTO `banka`.`cards` (`id`, `expire_date`, `pan`, `security_code`, `account_id`) VALUES ('1', '12-20', '1234567891234567', '123', '2');
