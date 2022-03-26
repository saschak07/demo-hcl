INSERT INTO asset (asset_id, company_name, create_time_stamp, modify_time_stamp, security_name, stock_price) VALUES (100, 'Company1', null, null, 'SecurityName1', 100);
INSERT INTO asset (asset_id, company_name, create_time_stamp, modify_time_stamp, security_name, stock_price) VALUES (101, 'Company2', null, null, 'SecurityName2', 200);

INSERT INTO audit (audit_id, create_time_stamp, modify_time_stamp, order_ref_no, portfolio_id, transaction_amount, transaction_type) VALUES (200, null, null, 300, 400, 100, 'buy');
INSERT INTO audit (audit_id, create_time_stamp, modify_time_stamp, order_ref_no, portfolio_id, transaction_amount, transaction_type) VALUES (201, null, null, 301, 400, 200, 'buy');

INSERT INTO orders (order_ref_no, asset_id, create_time_stamp, modify_time_stamp, order_date, order_price, order_qty, order_status, portfolio_id) VALUES (300, 100, null, null, '2022-03-25', 400, 10, 'SUBMIT', 400);
INSERT INTO orders (order_ref_no, asset_id, create_time_stamp, modify_time_stamp, order_date, order_price, order_qty, order_status, portfolio_id) VALUES (30, 100, null, null, '2022-03-25', 500, 20, 'FAIL', 400);

INSERT INTO portfolio (portfolio_id, create_time_stamp, modify_time_stamp, portfolio_name, running_balance) VALUES (400, null, null, 'PortfolioName1', 10000);
INSERT INTO portfolio (portfolio_id, create_time_stamp, modify_time_stamp, portfolio_name, running_balance) VALUES (401, null, null, 'PortfolioName2', 10000);
