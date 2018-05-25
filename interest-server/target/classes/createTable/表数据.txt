INSERT INTO sys_user (id, name, login_name, password, email) VALUES (1, '管理员', 'admin', '{bcrypt}$2a$10$D8E4cuanLviCCe/ASqBC7OZ84JYOH8IT4/y4JLAV/Pm/AdhzPcy2.', '123456@qq.com');
INSERT INTO sys_user (id, name, login_name, password, email) VALUES (2, '小明', 'test1', '{bcrypt}$2a$10$nr9nTKK2cm1fiGsC.UpGuudc.MtFgthcmRd652ubmrd0TMztB9tym', '123456@qq.com');
INSERT INTO sys_user (id, name, login_name, password, email) VALUES (3, '小刚', 'test2', '{bcrypt}$2a$10$anVOsbvMCJKgmC9pKmoqV.CMqQFktXEzb9KwQ2ILG7FBwlwHBOQwO', '123@qq.com');
INSERT INTO sys_user (id, name, login_name, password, email) VALUES (4, '小红', 'test3', '{bcrypt}$2a$10$m1lHapKhrZ4tH05Jtu.aG.KsZalgTqOVS0MZdOtpfJDPyr9Y71qWG', '123321@qq.com');

INSERT INTO sys_role (id, `role`, name, modules, `describe`) VALUES (1, 'ROLE_ADMIN', '管理员', '4;5;6;', '管理员');
INSERT INTO sys_role (id, `role`, name, modules, `describe`) VALUES (2, 'ROLE_TEST1', 'test1', '7;', '测试1');
INSERT INTO sys_role (id, `role`, name, modules, `describe`) VALUES (3, 'ROLE_TEST2', 'test2', '9;8;', '测试2');

INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (1, '系统管理', null, 0, 1, null, 'ios-flower');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (2, '菜单2', null, 0, 2, null, 'ios-flower-outline');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (3, '菜单3', null, 0, 3, null, 'ios-rose');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (4, '用户管理', '/base/user', 1, 1, null, 'ios-person');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (5, '菜单管理', '/base/menu', 1, 2, null, 'android-list');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (6, '角色管理', '/base/role', 1, 3, null, 'ios-people');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (7, '子菜单22', '/base/test4', 2, 2, null, 'ios-reverse-camera-outline');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (8, '子菜单31', '/base/test5', 3, 1, null, 'ios-eye');
INSERT INTO sys_menu (id, name, url, parent_id, sort, remark, icon) VALUES (9, '子菜单32', '/base/test6', 3, 2, null, 'ios-eye-outline');

INSERT INTO r_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO r_user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO r_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO r_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO r_user_role (user_id, role_id) VALUES (1, 3);
INSERT INTO r_user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO r_user_role (user_id, role_id) VALUES (4, 3);

INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('client', null, '{noop}secret', 'all', 'password,authorization_code,refresh_token,implicit,client_credentials', null, null, null, null, null, null);

