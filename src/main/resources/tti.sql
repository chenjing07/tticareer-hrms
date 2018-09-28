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
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_id          bigint comment 'Ա��id',
   in_time              datetime comment 'ת��ʱ��',
   out_time             datetime comment 'ת��ʱ��',
   archives_source      varchar(50) comment '��������',
   archives_destination varchar(50) comment '����ȥ��',
   archives_change      varchar(255) comment '�������˵��',
   state                int not null comment '״̬ 0����1����',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: assessment_standard                                   */
/*==============================================================*/
create table assessment_standard
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   position_id          bigint not null comment '��λid',
   work_result          varchar(255) not null comment '����ҵ��˵��',
   attitude             varchar(255) not null comment '����̬��˵��',
   quality              varchar(255) not null comment '��������˵��',
   skill                varchar(255) not null comment '��������˵��',
   calculation_way      varchar(255) not null comment '���˼��㷽��˵��',
   assessment_type      varchar(255) not null comment '���˷���˵��',
   result_level         varchar(255) not null comment '������𻮷�˵��',
   state                int not null comment '״̬
            {
            	0���� 1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: clock_detail                                          */
/*==============================================================*/
create table clock_detail
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_id          bigint not null comment 'Ա��id',
   morning_in           datetime comment '�����ϰ��ʱ��',
   mi_coordinate        geometry comment '�����ϰ�򿨵�ǰ����',
   morning_out          datetime comment '�����°��ʱ��',
   mo_coordinate        geometry comment '�����°�򿨵�ǰ����',
   afternoon_in         datetime comment '�����ϰ��ʱ��',
   ai_coordinate        geometry comment '�����ϰ�򿨵�ǰ����',
   afternoon_out        datetime comment '�����°��ʱ��',
   ao_coordinate        geometry comment '�����°�򿨵�ǰ����',
   state                int not null comment '״̬
            {
            	0�쳣 1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: department                                            */
/*==============================================================*/
create table department
(
   id                   bigint not null auto_increment comment 'Ψһid����������',
   superior_department_id bigint comment '�ϼ�����id',
   department_number    varchar(20) not null comment '���ű��',
   department_name      varchar(10) not null comment '��������',
   department_introduction varchar(255) not null comment '���ż��',
   state                int not null comment '״̬ 0����1����',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/
create table employee
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   user_name            varchar(30) comment '����  ���ű��+��λ���+Ա��id   ¼�˺�
            ',
   password             varchar(36),
   real_name            varchar(10) not null comment 'Ա����ʵ����',
   id_card_number       varchar(20) comment 'Ա�����֤��',
   id_card_picture      varchar(255) comment '���֤ͼƬ��ŵ�ַ',
   birthday             datetime not null comment '��������',
   gender               int not null comment '�Ա�1��0Ů',
   nation               varchar(10) not null comment '����',
   native_place         varchar(20) not null comment '����',
   registered_address   varchar(30) not null comment '���ڵ�ַ',
   house_address        varchar(255) not null comment '��ͥסַ',
   education            varchar(20) comment 'ѧ��',
   academic_degree      varchar(20) comment 'ѧλ',
   major                varchar(20) comment 'רҵ',
   tie                  varchar(20) comment 'ϵ��',
   graduated_school     varchar(20) comment '��ҵԺУ',
   graduated_time       datetime comment '��ҵʱ��',
   political_status     int not null comment '������ò
            {
            	0Ⱥ��1�й���Ա2�й�Ԥ����Ա3������Ա4��ﵳԱ5������Ա6�񽨻�Ա7�����Ա8ũ������Ա9�¹�����Ա10����ѧ����Ա11̨����Ա12�޵�����ʿ
            }',
   marital_status       int not null comment '����״�� 0δ��1�ѻ�',
   recruitment_source   int not null comment '��Ƹ��Դ
            {
            	1����ӦƸ2��Ƹ��վ3����;��
            }',
   account_bank         varchar(20) not null comment '��������',
   account_number       varchar(30) not null comment '�����˻�',
   phone_number         varchar(20) not null comment '�ֻ�����',
   email                varchar(30) not null comment '����',
   qq                   varchar(30) comment 'qq����',
   wechat               varchar(30) comment '΢�ź�',
   msn                  varchar(30) comment 'MSN',
   emergency_contact_name varchar(10) comment '������ϵ������',
   emergency_contact_relationship varchar(10) comment '������ϵ������',
   emergency_contact_number varchar(20) comment '������ϵ�˵绰',
   work_start           datetime comment '��ְʱ��',
   work_end             datetime comment '��ְʱ��',
   practice_start       datetime comment 'ʵϰ��ʼʱ��',
   practice_end         datetime comment 'ʵϰ����ʱ��',
   iswork               int not null comment '�Ƿ���ְ0��ְ1��ʽ2ʵϰ',
   state                int not null comment '״̬
            {
            	0Ϊ���ᣬ1Ϊ����Ա����2Ϊ���²���ͨԱ����3Ϊ���²�����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   check_satus          int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: employee_assessment                                   */
/*==============================================================*/
create table employee_assessment
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_id          bigint not null comment 'Ա��id',
   assessment_type      int not null comment '���˷���
            {
            	1�ճ����� 2���ڿ��� 3���ڿ��� 4�����ڿ��ˡ�
            }',
   work_result          int not null comment '����ҵ��
            {
            	1���� 2���� 3���� 0������
            }',
   attitude             int not null comment '{
            	1���� 2���� 3���� 0������
            }',
   quality              int not null comment '{
            	1���� 2���� 3���� 0������
            }',
   skill                int not null comment '{
            	1���� 2���� 3���� 0������
            }',
   assessment_result    int not null comment '{
            	1���� 2���� 3���� 0������
            }',
   evaluate             varchar(255) not null comment '����',
   state                int not null comment '״̬
            {
            	0���� 1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: employee_position_info                                */
/*==============================================================*/
create table employee_position_info
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_id          bigint not null comment 'Ա��id',
   position_id          bigint not null comment '��λid',
   arrive_post          datetime not null comment '����ʱ��',
   leave_post           datetime comment '����ʱ��',
   transfer_reason      varchar(255) comment '����ԭ��',
   leave_opinion        varchar(255) comment '�����������',
   arrive_opinion       varchar(255) comment '���벿�����',
   state                int not null comment '״̬ 0����1����',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: examination_questions                                 */
/*==============================================================*/
create table examination_questions
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   question             varchar(255) not null comment '��Ŀ',
   answer               varchar(255) not null comment '��',
   score                decimal not null comment '����',
   difficulty_level     int not null comment '�Ѷȵȼ�
            {
            	0�� 1�� 2��
            }	',
   category             int not null comment '����',
   explanation          varchar(255) not null comment '����',
   state                int not null comment '״̬
            {
            	0���� 1δʹ�� 2ʹ�� -1�д���
            }',
   create_time          datetime not null comment '¼��ʱ��',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: expense_account                                       */
/*==============================================================*/
create table expense_account
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_id          bigint not null comment 'Ա��id',
   time                 datetime not null comment '��������',
   content              varchar(255) not null comment '��������',
   reason               varchar(255) not null comment '����ԭ��',
   amount               decimal not null comment '�������',
   state                int not null comment '״̬
            {
            	0���� 1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: great_team                                            */
/*==============================================================*/
create table great_team
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   department_id        bigint not null comment '����id',
   commend              varchar(255) not null comment '��������',
   reward               varchar(255) not null comment '��������',
   state                int not null comment '״̬
            {
            	0���� 1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: holiday_statistics                                    */
/*==============================================================*/
create table holiday_statistics
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_id          bigint not null comment 'Ա��id',
   total_holidays       int not null comment '����������',
   total_leave_days     int not null comment '���������',
   state                int not null comment '״̬
            {
            	0���� 1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: interview                                             */
/*==============================================================*/
create table interview
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   resume_id            bigint not null comment '����id',
   one_content          varchar(255) not null comment '��������',
   one_start            datetime not null comment '���濪ʼʱ��',
   one_end              datetime not null comment '�������ʱ��',
   one_feedback         varchar(255) not null comment '���淴���ܽ�',
   two_content          varchar(255) not null comment '��������',
   two_start            datetime not null comment '���濪ʼʱ��',
   two_end              datetime not null comment '�������ʱ��',
   two_feedback         varchar(255) not null comment '���淴���ܽ�',
   state                int not null comment '״̬
            {
            	0��ѡ 1�������
            }',
   create_time          datetime not null comment '¼��ʱ��',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: labor_contract                                        */
/*==============================================================*/
create table labor_contract
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employer_name        varchar(10) not null comment '�׷����ƣ����˵�λ',
   employee_id          bigint not null comment '�ҷ����� Ա��id',
   contract_time_limit  int not null comment '��ͬ����',
   contract_start       datetime not null comment '��ʼʱ��',
   contract_end         datetime not null comment '����ʱ��',
   work_content         varchar(255) not null comment '��������',
   work_place           varchar(255) not null comment '�����ص�',
   labor_protection     varchar(255) not null comment '�Ͷ�����',
   labor_conditions     varchar(255) not null comment '�Ͷ�����',
   labor_reward         varchar(255) not null comment '�Ͷ�����',
   default_responsibility varchar(255) not null comment 'ΥԼ����',
   social_insurance     varchar(255) not null comment '��ᱣ��',
   contract_change      varchar(255) comment '��ͬ���',
   state                int not null comment '״̬ 0����1����',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: late_early                                            */
/*==============================================================*/
create table late_early
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_id          bigint not null comment 'Ա��id',
   late_early_time      datetime not null comment '�ٵ�����ʱ��',
   late_early_reason    varchar(255) not null comment '�ٵ�����ԭ��',
   state                int not null comment '״̬
            {
            	0���� 1�ٵ� 2����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: leave_detail                                          */
/*==============================================================*/
create table leave_detail
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_id          bigint not null comment 'Ա��id',
   leave_start          datetime not null comment '��ٿ�ʼʱ��',
   leave_end            datetime not null comment '��ٽ���ʱ��',
   leave_days           int not null comment '�������',
   reason               varchar(255) not null comment '���ԭ��',
   real_start           datetime comment '��˺���ڿ�ʼʱ��',
   real_end             datetime comment '��˺���ڽ���ʱ�䣨���٣�',
   state                int not null comment '״̬
            {
            	0���� 1���� 2���ٳɹ�
            }',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: over_work                                             */
/*==============================================================*/
create table over_work
(
   id           		bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_Id          bigint not null comment 'Ա��id',
   time         		datetime not null comment '�Ӱ�����',
   duration     		varchar(20) not null comment '�Ӱ�ʱ��',
   content      		varchar(255) not null comment '�Ӱ�����',
   state                int not null comment '״̬
            {
            	0�쳣 1����
            }',
   create_time    		datetime not null comment '¼��ʱ��',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: position                                              */
/*==============================================================*/
create table position
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   department_id        bigint comment '����id',
   position_number      varchar(25) not null comment '��λ���',
   position_name        varchar(10) not null comment '��λ����',
   superior_positionId  bigint comment '�ϼ���λid',
   position_introduction varchar(255) not null comment '��λ���',
   state                int not null comment '״̬ 0����1����',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: recruitment_demand                                    */
/*==============================================================*/
create table recruitment_demand
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   position_id          bigint not null comment '��λid',
   plan_number          int not null comment '�ƻ�����',
   salary               decimal not null comment 'н�ʴ���',
   supplemental_number  int comment '��������',
   supplement_reason    varchar(255) comment '����ԭ��',
   arrival_date         datetime not null comment '��������',
   language_requirements varchar(50) not null comment '����Ҫ��',
   professional_requirements varchar(50) not null comment 'רҵҪ��',
   educational_requirements varchar(50) not null comment 'ѧ��Ҫ��',
   computer_requirements varchar(50) not null comment '����Ҫ��',
   experience_requirements varchar(50) not null comment '����Ҫ��',
   age_requirements     varchar(50) not null comment '����Ҫ��',
   post_duties          varchar(255) not null comment '��λְ��',
   post_requirements    varchar(255) not null comment '��λҪ��',
   state                int not null comment '״̬
            {
            	0����1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: resume                                                */
/*==============================================================*/
create table resume
(
   id                   bigint not null comment 'Ψһ��ʶ����������',
   application_name     varchar(10) not null comment 'ӦƸ������',
   expected_position    varchar(10) not null comment '������ְλ',
   id_card_number       varchar(20) not null comment '���֤��',
   id_card_picture      varchar(0) not null comment '���֤ͼƬ��ŵ�ַ',
   birthday             datetime not null comment '��������',
   gender               int not null comment '�Ա�1��0Ů',
   nation               varchar(10) not null comment '����',
   native_place         varchar(20) not null comment '����',
   registered_address   varchar(30) not null comment '���ڵ�ַ',
   house_address        varchar(255) not null comment '��ͥסַ',
   political_status     int not null comment '������ò
            {
            	0Ⱥ��1�й���Ա2�й�Ԥ����Ա3������Ա4��ﵳԱ5������Ա6�񽨻�Ա7�����Ա8ũ������Ա9�¹�����Ա10����ѧ����Ա11̨����Ա12�޵�����ʿ
            }',
   marital_status       int not null comment '����״�� 0δ��1�ѻ�',
   phone_number         varchar(20) not null comment '�ֻ�����',
   email                varchar(30) not null comment '����',
   qq                   varchar(20) comment 'qq����',
   education            varchar(20) comment 'ѧ��',
   academic_degree      varchar(20) comment 'ѧλ',
   major                varchar(20) comment 'רҵ',
   tie                  varchar(20) comment 'ϵ��',
   graduated_school     varchar(20) comment '��ҵԺУ',
   graduated_time       datetime comment '��ҵʱ��',
   awards_received      varchar(255) comment '��õĽ���',
   language_level       varchar(10) not null comment '����ˮƽ',
   work_experience      varchar(255) not null comment '��������',
   hobbies              varchar(100) comment '��Ȥ����',
   self_evaluation      varchar(255) not null comment '��������',
   state                int not null comment '״̬
            {
            	0������ 1������� 2��ѡ
            }',
   create_time          datetime not null comment '¼��ʱ��',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: reward_punishment                                     */
/*==============================================================*/
create table reward_punishment
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_id          bigint not null comment 'Ա��id',
   reward_and_punishment int not null comment '����1��0��',
   content              varchar(255) not null comment '��������',
   state                int not null comment '״̬
            {
            	0���� 1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: salary_detail                                         */
/*==============================================================*/
create table salary_detail
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   employee_id          bigint not null comment 'Ա��id',
   basic_salary         decimal not null comment '��������',
   bonus                decimal comment '����',
   subsidy              decimal comment '����',
   over_work_salary     decimal comment '�Ӱ๤��',
   attendance_deduction decimal comment '����Ӧ��',
   salary_total         decimal not null comment 'н���ܺ�',
   now_year_month       datetime not null comment '����',
   state                int not null comment '״̬
            {
            	0���� 1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   check_status         int not null comment '��� 0�����1�����',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: training_feedback                                     */
/*==============================================================*/
create table training_feedback
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   training_info_id     bigint comment '��ѵ��Ϣ��ID',
   training_feedback    varchar(255) not null comment '��������',
   state                int not null comment '״̬
            {
            	0���� 1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: training_info                                         */
/*==============================================================*/
create table training_info
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   department_id        bigint comment '����id',
   employee_id          bigint comment 'Ա��id',
   lecturer             varchar(10) not null comment '��ʦ',
   time                 datetime not null comment '��ѵ��ʼʱ��',
   duration             varchar(20) not null comment '��ѵ�ƻ�ʱ��',
   purpose              varchar(255) not null comment '��ѵĿ��',
   number               int comment '�ƻ�����',
   cost                 decimal not null comment '�ƻ�����',
   place                varchar(255) not null comment '��ѵ�ص�',
   content              varchar(255) not null comment '��ѵ����',
   state                int not null comment '״̬
            {
            	0���� 1δ���� 2�ڽ���
            }',
   createTime           datetime not null comment '¼��ʱ��',
   note                 varchar(255) comment '��ע',
   primary key (id)
);

/*==============================================================*/
/* Table: written_examination                                   */
/*==============================================================*/
create table written_examination
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   resume_id            bigint not null comment '����id',
   exam_content_id      bigint not null comment '��������id',
   exam_start           datetime not null comment '����ʱ��',
   note                 varchar(255) comment '��ע',
   exam_score           decimal not null comment '���Գɼ�',
   exam_result          int not null comment '���Խ��
            {
            	1һ�� 0��ѡ
            }',
   create_time          datetime not null comment '¼��ʱ��',
   exam_end             datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: written_examination_content                           */
/*==============================================================*/
create table written_examination_content
(
   id                   bigint not null auto_increment comment 'Ψһ��ʶ����������',
   one_id               bigint not null comment '��Ŀ1id',
   two_id               bigint not null comment '��Ŀ2id',
   three_id             bigint not null comment '��Ŀ3id',
   four_id              bigint not null comment '��Ŀ4id',
   five_id              bigint not null comment '��Ŀ5id',
   six_id               bigint not null comment '��Ŀ6id',
   seven_id             bigint not null comment '��Ŀ7id',
   eight_id             bigint not null comment '��Ŀ8id',
   nine_id              bigint not null comment '��Ŀ9id',
   ten_id               bigint not null comment '��Ŀ10id',
   state                int not null comment '״̬
            {
            	0�쳣 1����
            }',
   create_time          datetime not null comment '¼��ʱ��',
   note                 varchar(255) comment '��ע',
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

alter table over_work add constraint FK_Reference_29 foreign key (employeeId)
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

