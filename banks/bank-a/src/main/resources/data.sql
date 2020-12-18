INSERT INTO `banka`.`client` (`id`, `address`, `company_name`, `name`, `surname`) VALUES ('1', 'Petra Drapsina 32, Novi Sad', 'Udruzenje', 'Mile', 'Milic');
INSERT INTO `banka`.`client` (`id`, `address`, `name`, `surname`) VALUES ('2', 'Puskinova 8, Novi Sad', 'Ana', 'Antic');

INSERT INTO `banka`.`merchant` (`id`, `merchant_id`, `merchant_password`) VALUES ('1', '123', '123');

INSERT INTO `banka`.`account` (`id`, `account_number`, `client_id`, `is_merchant`, `merchant_id`) VALUES ('1', '123123','1', b'1', '1');
INSERT INTO `banka`.`account` (`id`, `account_number`, `client_id`, `is_merchant`) VALUES ('2', '213213','2', b'0');

INSERT INTO `banka`.`card` (`id`, `expire_date`, `pan`, `security_code`, `account_id`) VALUES ('1', '2021-12-18T17:12:44.144070 ', '111', '111', '2');

INSERT INTO `banka`.`daily_balance` (`id`, `current`, `date_time`, `minus`, `plus`, `previous`, `account_id`) VALUES ('1', '100', ' 2020-12-18T17:12:44.144070 ', '0', '20', '80', '1');
INSERT INTO `banka`.`daily_balance` (`id`, `current`, `date_time`, `minus`, `plus`, `previous`, `account_id`) VALUES ('2', '20', ' 2020-12-18T17:12:44.144070 ', '20', '0', '40', '2');

INSERT INTO `banka`.`transaction` (`id`, `amount`, `issuer_id`, `merchant_id`, `merchant_order_id`, `payment_id`, `success`, `timestamp`) VALUES ('1', '20', '2', '123', '1', '1', b'1', '2020-12-18 17:12:44.144070');

