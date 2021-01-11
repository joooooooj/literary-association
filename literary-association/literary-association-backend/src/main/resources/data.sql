/*memberships*/
INSERT INTO `la`.`membership` (`id`, `name`, `duration`, `price`) VALUES ('1','Basic','30','50');
INSERT INTO `la`.`membership` (`id`, `name`, `duration`, `price`) VALUES ('2','Premium','90','110');

/*users*/
INSERT INTO `la`.`users` (`type`, `id`, `city`, `state`, `email`, `active`, `password`, `username`, `last_name`, `first_name`, `deleted`) VALUES ('ADMINISTRATOR', '1', 'Novi Sad', 'Srbija', 'marko@gmail.com', b'1', '$2a$10$xBbFGBwJcF9H3V/s2GfcnuVpM9niJ9oVrhY6CQjrrHZJYzYA6Z5nS', 'admin', 'Markovic', 'Marko', b'0');
INSERT INTO `la`.`users` (`type`, `id`, `city`, `state`, `email`, `active`, `password`, `username`, `last_name`, `first_name`, `deleted`) VALUES ('BOARD_MEMBER', '2', 'Beograd', 'Srbija', 'jovan@gmail.com', b'1', '$2a$10$xBbFGBwJcF9H3V/s2GfcnuVpM9niJ9oVrhY6CQjrrHZJYzYA6Z5nS', 'board_member', 'Jovic', 'Jovan', b'0');
INSERT INTO `la`.`users` (`type`, `id`, `city`, `state`, `email`, `active`, `password`, `username`, `last_name`, `first_name`, `deleted`) VALUES ('EDITOR', '3', 'Novi Sad', 'Srbija', 'jovana@gmail.com', b'1', '$2a$10$xBbFGBwJcF9H3V/s2GfcnuVpM9niJ9oVrhY6CQjrrHZJYzYA6Z5nS', 'editor', 'Jovanovic', 'Jovana', b'0');
INSERT INTO `la`.`users` (`type`, `id`, `city`, `state`, `email`, `active`, `password`, `username`, `last_name`, `first_name`, `deleted`, `membership_id`) VALUES ('WRITER', '4', 'Kragujevac', 'Srbija', 'jelena@gmail.com', b'1', '$2a$10$xBbFGBwJcF9H3V/s2GfcnuVpM9niJ9oVrhY6CQjrrHZJYzYA6Z5nS', 'writer', 'Jelic', 'Jelena', b'0', '1');
INSERT INTO `la`.`users` (`type`, `id`, `city`, `state`, `email`, `active`, `password`, `username`, `last_name`, `first_name`, `deleted`) VALUES ('LECTOR', '5', 'Indjija', 'Srbija', 'igor@gmail.com', b'1', '$2a$10$xBbFGBwJcF9H3V/s2GfcnuVpM9niJ9oVrhY6CQjrrHZJYzYA6Z5nS', 'lector', 'Malesevic', 'Igor', b'0');
INSERT INTO `la`.`users` (`type`, `id`, `city`, `state`, `email`, `active`, `password`, `username`, `last_name`, `first_name`, `deleted`, `membership_id`, `is_beta`) VALUES ('READER', '6', 'Backa Palanka', 'Srbija', 'ivana@gmail.com', b'1', '$2a$10$xBbFGBwJcF9H3V/s2GfcnuVpM9niJ9oVrhY6CQjrrHZJYzYA6Z5nS', 'reader', 'Brkic', 'Ivana', b'0', '2', b'0');
INSERT INTO `la`.`users` (`type`, `id`, `city`, `state`, `email`, `active`, `password`, `username`, `last_name`, `first_name`, `deleted`, `activated`, `payment_deadline`) VALUES ('WRITER_MEMBERSHIP_REQUEST', '7', 'Novi Sad', 'Srbija', 'ana@gmail.com', b'1', '$2a$10$xBbFGBwJcF9H3V/s2GfcnuVpM9niJ9oVrhY6CQjrrHZJYzYA6Z5nS', 'writer_membership_request', 'Anic', 'Ana', b'0', b'0', '2020-12-12');
INSERT INTO `la`.`users` (`type`, `id`, `city`, `state`, `email`, `active`, `password`, `username`, `last_name`, `first_name`, `deleted`, `is_beta`) VALUES ('READER', '8', 'Subotica', 'Srbija', 'boza@gmail.com', b'1', '$2a$10$xBbFGBwJcF9H3V/s2GfcnuVpM9niJ9oVrhY6CQjrrHZJYzYA6Z5nS', 'bozabozic', 'Bozic', 'Boza', b'0', b'1');

/*roles*/
INSERT INTO `la`.`role` (`id`, `name`) VALUES ('1', 'ADMIN');
INSERT INTO `la`.`role` (`id`, `name`) VALUES ('2', 'BOARD_MEMBER');
INSERT INTO `la`.`role` (`id`, `name`) VALUES ('3', 'EDITOR');
INSERT INTO `la`.`role` (`id`, `name`) VALUES ('4', 'WRITER');
INSERT INTO `la`.`role` (`id`, `name`) VALUES ('5', 'LECTOR');
INSERT INTO `la`.`role` (`id`, `name`) VALUES ('6', 'READER');
INSERT INTO `la`.`role` (`id`, `name`) VALUES ('7', 'WRITER_MEMBERSHIP_REQUEST');

/*user-roles*/
INSERT INTO `la`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `la`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `la`.`user_roles` (`user_id`, `role_id`) VALUES ('3', '3');
INSERT INTO `la`.`user_roles` (`user_id`, `role_id`) VALUES ('4', '4');
INSERT INTO `la`.`user_roles` (`user_id`, `role_id`) VALUES ('5', '5');
INSERT INTO `la`.`user_roles` (`user_id`, `role_id`) VALUES ('6', '6');
INSERT INTO `la`.`user_roles` (`user_id`, `role_id`) VALUES ('7', '7');

/*permissions*/

/*role-permissions*/

/*membership_request*/
INSERT INTO `la`.`membership_request` (`id`, `status`, `reader_id`) VALUES ('1', '1', '7');

/*submitted_work*/
INSERT INTO `la`.`submitted_work` (`id`, `reviewed`, `path`, `request_id`) VALUES ('1', b'0', 'path', '7');

/*board_member_comment*/
INSERT INTO `la`.`board_member_comment` (`id`, `text`, `date`, `opinion`, `submitted_work_id`, `board_member_id`) VALUES ('1', 'komentar', '2020-12-12', '1','1','6');

/*publisher*/
INSERT INTO `la`.`publisher` (`id`, `account_number`, `city`, `state`, `name`) VALUES ('1', '12827228828282', 'Beograd', 'Srbija','laguna');

/*genre*/
INSERT INTO `la`.`genre` (`id`, `code`, `name`) VALUES ('1', 'hr', 'Horor');
INSERT INTO `la`.`genre` (`id`, `code`, `name`) VALUES ('2', 'km', 'Komedija');
INSERT INTO `la`.`genre` (`id`, `code`, `name`) VALUES ('3', 'dr', 'Drama');

/*reader_genre*/
INSERT INTO `la`.`reader_genre` (`reader_id`, `genre_id`) VALUES ('6','1');
INSERT INTO `la`.`reader_genre` (`reader_id`, `genre_id`) VALUES ('6','2');
INSERT INTO `la`.`reader_genre` (`reader_id`, `genre_id`) VALUES ('8','1');
INSERT INTO `la`.`reader_genre` (`reader_id`, `genre_id`) VALUES ('8','3');

/*beta_reader_genre*/
INSERT INTO `la`.`beta_reader_genre` (`beta_reader_id`, `genre_id`) VALUES ('8','1');

/*script*/
INSERT INTO `la`.`script` (`id`, `path`) VALUES ('1','path');

/*publish_book_request*/
INSERT INTO `la`.`publish_book_request` (`id`, `synopsis`, `title`, `editor_id`, `genre_id`, `writer_id`) VALUES ('1', 'synopsis', 'Knjiga', '3', '2', '4');

/*script_request*/
INSERT INTO `la`.`script_request` (`id`, `changes_deadline`, `corrections`, `status`, `submit_deadline`, `suggestions`, `lector_id`, `script_id`, `publish_book_request_id`) VALUES ('1', null, null, '2', '2020-12-20', null, '5', '1', '1');

/*book*/
INSERT INTO `la`.`book` (`id`, `isbn`, `pages_number`, `price`, `published_year`, `synopsis`, `title`, `genre_id`, `lector_id`, `publisher_id`, `script_id`) VALUES ('1', '3434734', '256', '10', '2020', 'blabla', 'Kuvar', '1', '5', '1', '1');
INSERT INTO `la`.`book` (`id`, `isbn`, `pages_number`, `price`, `published_year`, `synopsis`, `title`, `genre_id`, `lector_id`, `publisher_id`, `script_id`) VALUES ('2', '1231231', '256', '10', '2020', 'blabla', 'Stephen King', '1', '5', '1', '1');
INSERT INTO `la`.`book` (`id`, `isbn`, `pages_number`, `price`, `published_year`, `synopsis`, `title`, `genre_id`, `lector_id`, `publisher_id`, `script_id`) VALUES ('3', '3213213', '256', '10', '2020', 'blabla', 'Bernard Cornwall', '1', '5', '1', '1');
INSERT INTO `la`.`book` (`id`, `isbn`, `pages_number`, `price`, `published_year`, `synopsis`, `title`, `genre_id`, `lector_id`, `publisher_id`, `script_id`) VALUES ('4', '2312312', '256', '10', '2020', 'blabla', 'Elizabeth Gilbert', '1', '5', '1', '1');

/*book_key_words*/
INSERT INTO `la`.book_key_words (`book_id`, `key_words`) VALUES ('1', 'mleko');
INSERT INTO `la`.book_key_words (`book_id`, `key_words`) VALUES ('1', 'sos');

/*beta_reader_comment*/
INSERT INTO `la`.`beta_reader_comment` (`id`, `deadline`, `text`, `reader_id`, `script_request_id`) VALUES ('1', '2020-12-20 00:00:00.000000', 'Lepo', '8', '1');
