DROP VIEW user_table_view;
DROP VIEW reimb_table_view;
DROP VIEW user_reimbt_table_view;
DROP TABLE ers_reimbursement;
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_users;
DROP TABLE ers_user_roles;



--CREATE TABLES AND VIEWS
CREATE TABLE ers_reimbursement_status(
	reimb_status_id SERIAL PRIMARY KEY
	, reimb_status VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE ers_reimbursement_type(
	reimb_type_id SERIAL PRIMARY KEY
	, reimb_type VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE ers_user_roles (
	ers_user_role_id SERIAL PRIMARY KEY
	, user_role VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE ers_users(
	ers_users_id SERIAL PRIMARY KEY
	, ers_username VARCHAR(50) NOT NULL UNIQUE
	, ers_password VARCHAR(50) NOT NULL
	, user_first_name VARCHAR(100) NOT NULL
	, user_last_name VARCHAR(100) NOT NULL
	, user_email VARCHAR(150) NOT NULL UNIQUE
	, user_role_id INTEGER NOT NULL
	, CONSTRAINT user_role_id_constraint FOREIGN KEY(user_role_id) REFERENCES ers_user_roles(ers_user_role_id)
);



CREATE TABLE ers_reimbursement(
	reimb_id serial PRIMARY KEY
	, reimb_amount NUMERIC NOT NULL
	, reimb_submitted TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
	, reimb_resolved TIMESTAMP 
	, reimb_description VARCHAR(250)
	, reimb_author INTEGER NOT NULL
	, reimb_resolver INTEGER
	, reimb_status_id INTEGER NOT NULL
	, reimb_type_id INTEGER NOT NULL
	, CONSTRAINT reimb_author_constraint FOREIGN KEY(reimb_author) REFERENCES ers_users(ers_users_id)
	, CONSTRAINT reimb_resolver_constraint FOREIGN KEY(reimb_resolver) REFERENCES ers_users(ers_users_id)
	, CONSTRAINT reimb_status_id_constraint FOREIGN KEY(reimb_status_id) REFERENCES ers_reimbursement_status(reimb_status_id)
	, CONSTRAINT  reimb_type_id_constraint FOREIGN KEY(reimb_type_id) REFERENCES ERS_REIMBURSEMENT_TYPE(reimb_type_id)
);

CREATE VIEW reimb_table_view AS
SELECT reimb_amount, reimb_submitted, reimb_resolved,
reimb_description, reimb_author, reimb_resolver, reims.reimb_status_id,
reims.reimb_type_id, reims.reimb_id , u1.ers_username AS author_name, u2.ers_username AS resolver_name,
reimb_status, reimb_type
FROM ers_reimbursement reims
INNER JOIN ers_users u1 ON reims.reimb_author = u1.ers_users_id
INNER JOIN ers_reimbursement_status rs ON reims.reimb_status_id = rs.reimb_status_id
INNER  JOIN ers_reimbursement_type rt ON reims.reimb_type_id = rt.reimb_type_id
LEFT JOIN ers_users u2 ON reims.reimb_resolver = u2.ers_users_id;



CREATE VIEW user_table_view AS
SELECT * FROM ers_users eu INNER JOIN ers_user_roles eur 
ON eu.user_role_id = eur.ers_user_role_id ;

CREATE VIEW user_reimbt_table_view AS
SELECT * FROM ers_users eu INNER JOIN ers_reimbursement er 
ON eu.ers_users_id = er.reimb_author;




INSERT INTO ers_reimbursement_type(reimb_type) VALUES ('LODGING');
INSERT INTO ers_reimbursement_type(reimb_type) VALUES ('TRAVEL');
INSERT INTO ers_reimbursement_type(reimb_type) VALUES ('FOOD');
INSERT INTO ers_reimbursement_type(reimb_type) VALUES ('OTHER');

INSERT INTO ers_reimbursement_status(reimb_status) VALUES ('PENDING');
INSERT INTO ers_reimbursement_status(reimb_status) VALUES ('APPROVED');
INSERT INTO ers_reimbursement_status(reimb_status) VALUES ('REJECTED');

INSERT INTO ers_user_roles(user_role) VALUES('MANAGER');
INSERT INTO ers_user_roles(user_role) VALUES('EMPLOYEE');


INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('manager', 'password', 'fName1', 'lName1', 'manager@company.com', 1);
INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('employee1', 'password', 'fName2', 'lName2', 'employee1@company.com', 2);
INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('employee2', 'password', 'fName3', 'lName3', 'employee2@company.com', 2);
INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('employee3', 'password', 'fName4', 'lName4', 'employee3@company.com', 2);


INSERT INTO ers_reimbursement(reimb_amount, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES( 300, null, 2, null, 1, 1);
INSERT INTO ers_reimbursement(reimb_amount, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES( 300, 'for stuff', 2, null, 1, 1);
INSERT INTO ers_reimbursement(reimb_amount, reimb_author, reimb_status_id, reimb_type_id ) VALUES( 200,  3, 1, 1);
INSERT INTO ers_reimbursement(reimb_amount, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES( 300, null, 4, null, 1, 2);


SELECT * FROM ers_users WHERE ers_username = 'employee1' AND ers_password = 'password'


SELECT ers.reimb_id, ers.reimb_amount, ers.reimb_submitted, ers.reimb_resolved, ers.reimb_description
	, ers.reimb_author, ers.reimb_resolver, ers.reimb_status_id, ers.reimb_type_id 
FROM ers_reimbursement ers 
WHERE ers.reimb_author = 1;


SELECT * FROM reimbursement_table_view WHERE ers_username = 'manager';



SELECT * FROM ers_reimbursement_type;
SELECT * FROM ers_reimbursement_status;
SELECT * FROM ers_user_roles;
SELECT * FROM ers_users;
SELECT * FROM ers_reimbursement;


SELECT * FROM user_table_view;
SELECT * FROM reimb_table_view;
SELECT * FROM user_reimbt_table_view;

SELECT * FROM reimb_table_view WHERE reimb_author = 2;




