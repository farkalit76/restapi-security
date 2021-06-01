DROP TABLE IF EXISTS `refund_txn_info`;
CREATE TABLE `refund_txn_info` (
    `id`                BIGINT          NOT NULL AUTO_INCREMENT,
    `txn_id`            VARCHAR(20)     NOT NULL,
    `order_id`          VARCHAR(20)     NOT NULL,
	  `request_id`        VARCHAR(36)     NOT NULL,
    `channel`           VARCHAR(20)     NOT NULL,
    `amount`            DECIMAL(10, 2)  NOT NULL,
	  `type`              VARCHAR(20)     NOT NULL,
    `status`            VARCHAR(30)     NOT NULL,
    `extended_info`     JSON            DEFAULT NULL,
    `current_phase`     VARCHAR(100)    NOT NULL,
    `last_phase`        VARCHAR(100)    DEFAULT NULL,
    `created_on`        TIMESTAMP(3)     NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    `updated_on`        TIMESTAMP(3)     NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_cxt_request_id` (`request_id`, `channel`),
    UNIQUE KEY `unique_cxt_request_id_order_id_type` (`request_id`, `order_id`, `type`),
    UNIQUE KEY `unique_cxt_txn_id` (`txn_id`),
    KEY `cxt_created_on` (`created_on`),
    KEY `cxt_updated_on` (`updated_on`)
);