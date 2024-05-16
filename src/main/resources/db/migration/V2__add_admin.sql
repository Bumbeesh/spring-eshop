INSERT INTO users(id, archive, name, password, role, bucket_id)
VALUES (1, false, 'admin', '$2a$10$Rx4ztcYEFKw4bcEl.T6kgu9UL.coB1manfDkndzBftBIOsT0JB2nS', 'ADMIN', null);

ALTER SEQUENCE users_seq RESTART with 2;
