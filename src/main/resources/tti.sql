/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/9/25 15:52:59                           */
/*==============================================================*/


drop table if exists archives;

drop table if exists assessment_standard;

drop table if exists clock_detail;

drop table if exists department;

drop table if exists employee;

drop table if exists employee_assessment;

drop table if exists employee_position_info;

drop table if exists examination_questions;

drop table if exists expense_account;

drop table if exists great_team;

drop table if exists holiday_statistics;

drop table if exists interview;

drop table if exists labor_contract;

drop table if exists late_early;

drop table if exists leave_detail;

drop table if exists over_work;

drop table if exists position;

drop table if exists recruitment_demand;

drop table if exists resume;

drop table if exists reward_punishment;

drop table if exists salary_detail;

drop table if exists training_feedback;

drop table if exists training_info;

drop table if exists written_examination;

drop table if exists written_examination_content;

/*==============================================================*/
/* Table: archives                                              */
/*==============================================================*/
create table archives
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint comment '员工id',
   in_time              datetime comment '转入时间',
   out_time             datetime comment '转出时间',
   archives_source      varchar(50) comment '档案来处',
   archives_destination varchar(50) comment '档案去处',
   archives_change      varchar(255) comment '档案变更说明',
   state                int not null comment '状态 0以往1现在',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: assessment_standard                                   */
/*==============================================================*/
create table assessment_standard
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   position_id          bigint not null comment '岗位id',
   work_result          varchar(255) not null comment '工作业绩说明',
   attitude             varchar(255) not null comment '工作态度说明',
   quality              varchar(255) not null comment '工作质量说明',
   skill                varchar(255) not null comment '工作技能说明',
   calculation_way      varchar(255) not null comment '考核计算方法说明',
   assessment_type      varchar(255) not null comment '考核分类说明',
   result_level         varchar(255) not null comment '结果级别划分说明',
   state                int not null comment '状态
            {
            	0冻结 1激活
            }',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: clock_detail                                          */
/*==============================================================*/
create table clock_detail
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint not null comment '员工id',
   clock_in           	datetime comment '上班打卡时间',
   clock_out        	datetime comment '下班打卡时间',
   state                int not null comment '状态
            {
            	0异常 1按例
            }',
   create_time          datetime not null comment '录入时间',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: department                                            */
/*==============================================================*/
create table department
(
   id                   bigint not null auto_increment comment '唯一id，主键自增',
   superior_department_id bigint comment '上级部门id',
   department_number    varchar(30) not null comment '部门编号',
   department_name      varchar(30) not null comment '部门名称',
   department_introduction varchar(255) not null comment '部门简介',
   state                int not null comment '状态 0冻结1激活',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/
create table employee
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   user_name            varchar(30) comment '工号  部门编号+岗位编号+员工id   录账号
            ',
   password             varchar(36),
   real_name            varchar(30) not null comment '员工真实姓名',
   id_card_number       varchar(30) comment '员工身份证号',
   id_card_picture      varchar(255) comment '身份证图片存放地址',
   birthday             datetime not null comment '出生年月',
   gender               int not null comment '性别1男0女',
   nation               varchar(50) not null comment '民族',
   native_place         varchar(50) not null comment '籍贯',
   registered_address   varchar(255) not null comment '户口地址',
   house_address        varchar(255) not null comment '家庭住址',
   education            varchar(50) comment '学历',
   academic_degree      varchar(50) comment '学位',
   major                varchar(50) comment '专业',
   tie                  varchar(50) comment '系别',
   graduated_school     varchar(50) comment '毕业院校',
   graduated_time       datetime comment '毕业时间',
   political_status     int not null comment '政治面貌
            {
            	0群众1中共党员2中共预备党员3共青团员4民革党员5民盟盟员6民建会员7民进会员8农工党党员9致公党党员10九三学社社员11台盟盟员12无党派人士
            }',
   marital_status       int not null comment '婚姻状况 0未婚1已婚',
   recruitment_source   int not null comment '招聘来源
            {
            	1简历应聘2招聘网站3其它途径
            }',
   account_bank         varchar(30) not null comment '开户银行',
   account_number       varchar(30) not null comment '工资账户',
   phone_number         varchar(20) not null comment '手机号码',
   email                varchar(50) not null comment '邮箱',
   qq                   varchar(30) comment 'qq号码',
   wechat               varchar(30) comment '微信号',
   msn                  varchar(30) comment 'MSN',
   emergency_contact_name varchar(30) comment '紧急联系人姓名',
   emergency_contact_relationship varchar(50) comment '紧急联系人关系',
   emergency_contact_number varchar(30) comment '紧急联系人电话',
   work_start           datetime comment '入职时间',
   work_end             datetime comment '离职时间',
   practice_start       datetime comment '实习开始时间',
   practice_end         datetime comment '实习结束时间',
   iswork               int not null comment '是否在职0离职1正式2实习',
   state                int not null comment '状态
            {
            	0为冻结，1为其他员工，2为人事部普通员工，3为人事部经理
            }',
   create_time          datetime not null comment '录入时间',
   check_satus          int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: employee_assessment                                   */
/*==============================================================*/
create table employee_assessment
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint not null comment '员工id',
   assessment_type      int not null comment '考核分类
            {
            	1日常考核 2定期考核 3长期考核 4不定期考核。
            }',
   work_result          int not null comment '工作业绩
            {
            	1优秀 2良好 3及格 0不及格
            }',
   attitude             int not null comment '{
            	1优秀 2良好 3及格 0不及格
            }',
   quality              int not null comment '{
            	1优秀 2良好 3及格 0不及格
            }',
   skill                int not null comment '{
            	1优秀 2良好 3及格 0不及格
            }',
   assessment_result    int not null comment '{
            	1优秀 2良好 3及格 0不及格
            }',
   evaluate             varchar(255) not null comment '评价',
   state                int not null comment '状态
            {
            	0冻结 1激活
            }',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: employee_position_info                                */
/*==============================================================*/
create table employee_position_info
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint not null comment '员工id',
   position_id          bigint not null comment '岗位id',
   arrive_post          datetime not null comment '到岗时间',
   leave_post           datetime comment '调岗时间',
   transfer_reason      varchar(255) comment '调岗原因',
   leave_opinion        varchar(255) comment '调出部门意见',
   arrive_opinion       varchar(255) comment '调入部门意见',
   state                int not null comment '状态 0以往1现在',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: examination_questions                                 */
/*==============================================================*/
create table examination_questions
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   question             varchar(255) not null comment '题目',
   answer               varchar(255) not null comment '答案',
   score                decimal not null comment '分数',
   difficulty_level     int not null comment '难度等级
            {
            	0易 1中 2难
            }	',
   category             int not null comment '分类
   		{
   			1选择题 2填空题 3问答题 4计算题
   		}',
   explanation          varchar(255) not null comment '讲解',
   state                int not null comment '状态
            {
            	0冻结 1未使用 2使用 -1有错误
            }',
   create_time          datetime not null comment '录入时间',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: expense_account                                       */
/*==============================================================*/
create table expense_account
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint not null comment '员工id',
   time                 datetime not null comment '报销日期',
   content              varchar(255) not null comment '报销内容',
   reason               varchar(255) not null comment '报销原因',
   amount               decimal not null comment '报销金额',
   state                int not null comment '状态
            {
            	0冻结 1激活
            }',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: great_team                                            */
/*==============================================================*/
create table great_team
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   department_id        bigint not null comment '部门id',
   commend              varchar(255) not null comment '表彰内容',
   reward               varchar(255) not null comment '奖励内容',
   state                int not null comment '状态
            {
            	0冻结 1激活
            }',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: holiday_statistics                                    */
/*==============================================================*/
create table holiday_statistics
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint not null comment '员工id',
   total_holidays       int not null comment '假期总天数',
   total_leave_days     int not null comment '已请假天数',
   state                int not null comment '状态
            {
            	0冻结 1激活
            }',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: interview                                             */
/*==============================================================*/
create table interview
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   resume_id            bigint not null comment '简历id',
   one_content          varchar(255) not null comment '初面内容',
   one_start            datetime not null comment '初面开始时间',
   one_end              datetime not null comment '初面结束时间',
   one_feedback         varchar(255) not null comment '初面反馈总结',
   two_content          varchar(255) not null comment '复面内容',
   two_start            datetime not null comment '复面开始时间',
   two_end              datetime not null comment '复面结束时间',
   two_feedback         varchar(255) not null comment '复面反馈总结',
   state                int not null comment '状态
            {
            	0落选 1进入二面2录用
            }',
   create_time          datetime not null comment '录入时间',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: labor_contract                                        */
/*==============================================================*/
create table labor_contract
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employer_name        varchar(10) not null comment '甲方名称，用人单位',
   employee_id          bigint not null comment '乙方名称 员工id',
   contract_time_limit  int not null comment '合同期限',
   contract_start       datetime not null comment '开始时间',
   contract_end         datetime not null comment '结束时间',
   work_content         varchar(255) not null comment '工作内容',
   work_place           varchar(255) not null comment '工作地点',
   labor_protection     varchar(255) not null comment '劳动保护',
   labor_conditions     varchar(255) not null comment '劳动条件',
   labor_reward         varchar(255) not null comment '劳动报酬',
   default_responsibility varchar(255) not null comment '违约责任',
   social_insurance     varchar(255) not null comment '社会保险',
   contract_change      varchar(255) comment '合同变更',
   state                int not null comment '状态 0以往1现在',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: late_early                                            */
/*==============================================================*/
create table late_early
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint not null comment '员工id',
   late_early_time      datetime not null comment '迟到早退时间',
   late_early_reason    varchar(255) not null comment '迟到早退原因',
   state                int not null comment '状态
            {
            	0冻结 1迟到 2早退
            }',
   create_time          datetime not null comment '录入时间',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: leave_detail                                          */
/*==============================================================*/
create table leave_detail
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint not null comment '员工id',
   leave_start          datetime not null comment '请假开始时间',
   leave_end            datetime not null comment '请假结束时间',
   leave_days           int not null comment '请假天数',
   reason               varchar(255) not null comment '请假原因',
   real_start           datetime comment '审核后假期开始时间',
   real_end             datetime comment '审核后假期结束时间（销假）',
   state                int not null comment '状态
            {
            	0冻结 1激活 2销假成功
            }',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: over_work                                             */
/*==============================================================*/
create table over_work
(
   id           		bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint not null comment '员工id',
   time         		datetime not null comment '加班日期',
   duration     		varchar(50) not null comment '加班时长',
   content      		varchar(255) not null comment '加班内容',
   state                int not null comment '状态
            {
            	0异常 1正常
            }',
   create_time    		datetime not null comment '录入时间',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: position                                              */
/*==============================================================*/
create table position
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   department_id        bigint comment '部门id',
   position_number      varchar(50) not null comment '岗位编号',
   position_name        varchar(50) not null comment '岗位名称',
   superior_positionId  bigint comment '上级岗位id',
   position_introduction varchar(255) not null comment '岗位简介',
   state                int not null comment '状态 0冻结1激活',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: recruitment_demand                                    */
/*==============================================================*/
create table recruitment_demand
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   position_id          bigint not null comment '岗位id',
   plan_number          int not null comment '计划人数',
   salary               decimal not null comment '薪资待遇',
   supplemental_number  int comment '增补人数',
   supplement_reason    varchar(255) comment '增补原因',
   arrival_date         datetime not null comment '到岗日期',
   language_requirements varchar(255) not null comment '外语要求',
   professional_requirements varchar(255) not null comment '专业要求',
   educational_requirements varchar(255) not null comment '学历要求',
   computer_requirements varchar(255) not null comment '电脑要求',
   experience_requirements varchar(255) not null comment '经验要求',
   age_requirements     varchar(255) not null comment '年龄要求',
   post_duties          varchar(255) not null comment '岗位职责',
   post_requirements    varchar(255) not null comment '岗位要求',
   state                int not null comment '状态
            {
            	0冻结1激活
            }',
   create_time          datetime not null comment '录入时间',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: resume                                                */
/*==============================================================*/
create table resume
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   application_name     varchar(50) not null comment '应聘人姓名',
   expected_position    varchar(50) not null comment '期望的职位',
   id_card_number       varchar(30) not null comment '身份证号',
   id_card_picture      varchar(100) not null comment '身份证图片存放地址',
   birthday             datetime not null comment '出生年月',
   gender               int not null comment '性别1男0女',
   nation               varchar(30) not null comment '民族',
   native_place         varchar(30) not null comment '籍贯',
   registered_address   varchar(255) not null comment '户口地址',
   house_address        varchar(255) not null comment '家庭住址',
   political_status     int not null comment '政治面貌
            {
            	0群众1中共党员2中共预备党员3共青团员4民革党员5民盟盟员6民建会员7民进会员8农工党党员9致公党党员10九三学社社员11台盟盟员12无党派人士
            }',
   marital_status       int not null comment '婚姻状况 0未婚1已婚',
   phone_number         varchar(20) not null comment '手机号码',
   email                varchar(50) not null comment '邮箱',
   qq                   varchar(20) comment 'qq号码',
   education            varchar(50) comment '学历',
   academic_degree      varchar(50) comment '学位',
   major                varchar(50) comment '专业',
   tie                  varchar(50) comment '系别',
   graduated_school     varchar(255) comment '毕业院校',
   graduated_time       datetime comment '毕业时间',
   awards_received      varchar(255) comment '获得的奖项',
   language_level       varchar(255) not null comment '语言水平',
   work_experience      varchar(255) not null comment '工作经验',
   hobbies              varchar(255) comment '兴趣爱好',
   self_evaluation      varchar(255) not null comment '自我评价',
   state                int not null comment '状态
            {
            	0待处理 1进入笔试 2落选
            }',
   create_time          datetime not null comment '录入时间',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: reward_punishment                                     */
/*==============================================================*/
create table reward_punishment
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint not null comment '员工id',
   reward_and_punishment int not null comment '奖惩1奖0惩',
   content              varchar(255) not null comment '奖惩内容',
   state                int not null comment '状态
            {
            	0冻结 1激活
            }',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: salary_detail                                         */
/*==============================================================*/
create table salary_detail
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id          bigint not null comment '员工id',
   basic_salary         decimal not null comment '基本工资',
   bonus                decimal comment '奖金',
   subsidy              decimal comment '补贴',
   over_work_salary     decimal comment '加班工资',
   attendance_deduction decimal comment '考勤应扣',
   salary_total         decimal not null comment '薪资总和',
   now_year_month       datetime not null comment '年月',
   state                int not null comment '状态
            {
            	0冻结 1激活
            }',
   create_time          datetime not null comment '录入时间',
   check_status         int not null comment '审核 0待审核1已审核',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: training_feedback                                     */
/*==============================================================*/
create table training_feedback
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   employee_id			bigint comment '员工信息表ID',
   training_info_id     bigint comment '培训信息表ID',
   training_feedback    varchar(255) comment '反馈内容',
   state                int not null comment '状态
            {
            	0冻结 1激活
            }',
   create_time          datetime not null comment '录入时间',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: training_info                                         */
/*==============================================================*/
create table training_info
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   department_id        bigint comment '部门id',
   employee_id          bigint comment '员工id',
   lecturer             varchar(30) not null comment '讲师',
   time                 datetime not null comment '培训开始时间',
   duration             varchar(30) not null comment '培训计划时长',
   purpose              varchar(255) not null comment '培训目的',
   number               int comment '计划人数',
   cost                 decimal not null comment '计划费用',
   place                varchar(255) not null comment '培训地点',
   content              varchar(255) not null comment '培训内容',
   state                int not null comment '状态
            {
            	0冻结 1未进行 2在进行
            }',
   create_time          datetime not null comment '录入时间',
   note                 varchar(255) comment '备注',
   primary key (id)
);

/*==============================================================*/
/* Table: written_examination                                   */
/*==============================================================*/
create table written_examination
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   resume_id            bigint not null comment '简历id',
   exam_content_id      bigint not null comment '笔试内容id',
   exam_start           datetime not null comment '笔试时间',
   note                 varchar(255) comment '备注',
   exam_score           decimal not null comment '笔试成绩',
   exam_result          int not null comment '笔试结果
            {
            	1一面 0落选
            }',
   create_time          datetime not null comment '录入时间',
   exam_end             datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: written_examination_content                           */
/*==============================================================*/
create table written_examination_content
(
   id                   bigint not null auto_increment comment '唯一标识，主键自增',
   one_id               bigint not null comment '题目1id',
   two_id               bigint not null comment '题目2id',
   three_id             bigint not null comment '题目3id',
   four_id              bigint not null comment '题目4id',
   five_id              bigint not null comment '题目5id',
   six_id               bigint not null comment '题目6id',
   seven_id             bigint not null comment '题目7id',
   eight_id             bigint not null comment '题目8id',
   nine_id              bigint not null comment '题目9id',
   ten_id               bigint not null comment '题目10id',
   state                int not null comment '状态
            {
            	0异常 1正常
            }',
   create_time          datetime not null comment '录入时间',
   note                 varchar(255) comment '备注',
   primary key (id)
);

alter table archives add constraint FK_Reference_4 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table assessment_standard add constraint FK_Reference_34 foreign key (position_id)
      references position (id) on delete restrict on update restrict;

alter table clock_detail add constraint FK_Reference_32 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table department add constraint FK_Reference_38 foreign key (superior_department_id)
      references department (id) on delete restrict on update restrict;

alter table employee_assessment add constraint FK_Reference_31 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table employee_position_info add constraint FK_Reference_2 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table employee_position_info add constraint FK_Reference_22 foreign key (position_id)
      references position (id) on delete restrict on update restrict;

alter table expense_account add constraint FK_Reference_26 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table great_team add constraint FK_Reference_33 foreign key (department_id)
      references department (id) on delete restrict on update restrict;

alter table holiday_statistics add constraint FK_Reference_35 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table interview add constraint FK_Reference_21 foreign key (resume_id)
      references resume (id) on delete restrict on update restrict;

alter table labor_contract add constraint FK_Reference_3 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table late_early add constraint FK_Reference_25 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table leave_detail add constraint FK_Reference_27 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table over_work add constraint FK_Reference_29 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table position add constraint FK_Reference_36 foreign key (department_id)
      references department (id) on delete restrict on update restrict;

alter table position add constraint FK_Reference_7 foreign key (superior_positionId)
      references position (id) on delete restrict on update restrict;

alter table recruitment_demand add constraint FK_Reference_37 foreign key (position_id)
      references position (id) on delete restrict on update restrict;

alter table reward_punishment add constraint FK_Reference_28 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table salary_detail add constraint FK_Reference_30 foreign key (employee_id)
      references employee (id) on delete restrict on update restrict;

alter table training_feedback add constraint FK_Reference_23 foreign key (training_info_id)
      references training_info (id) on delete restrict on update restrict;

alter table written_examination add constraint FK_Reference_19 foreign key (exam_content_id)
      references written_examination_content (id) on delete restrict on update restrict;

alter table written_examination add constraint FK_Reference_20 foreign key (resume_id)
      references resume (id) on delete restrict on update restrict;

alter table written_examination_content add constraint FK_Reference_10 foreign key (two_id)
      references examination_questions (id) on delete restrict on update restrict;

alter table written_examination_content add constraint FK_Reference_11 foreign key (three_id)
      references examination_questions (id) on delete restrict on update restrict;

alter table written_examination_content add constraint FK_Reference_12 foreign key (four_id)
      references examination_questions (id) on delete restrict on update restrict;

alter table written_examination_content add constraint FK_Reference_13 foreign key (five_id)
      references examination_questions (id) on delete restrict on update restrict;

alter table written_examination_content add constraint FK_Reference_14 foreign key (six_id)
      references examination_questions (id) on delete restrict on update restrict;

alter table written_examination_content add constraint FK_Reference_15 foreign key (seven_id)
      references examination_questions (id) on delete restrict on update restrict;

alter table written_examination_content add constraint FK_Reference_16 foreign key (eight_id)
      references examination_questions (id) on delete restrict on update restrict;

alter table written_examination_content add constraint FK_Reference_17 foreign key (nine_id)
      references examination_questions (id) on delete restrict on update restrict;

alter table written_examination_content add constraint FK_Reference_18 foreign key (ten_id)
      references examination_questions (id) on delete restrict on update restrict;

alter table written_examination_content add constraint FK_Reference_9 foreign key (one_id)
      references examination_questions (id) on delete restrict on update restrict;

