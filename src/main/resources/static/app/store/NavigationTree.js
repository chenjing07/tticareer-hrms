Ext.define('Admin.store.NavigationTree', {
    extend: 'Ext.data.TreeStore',

    storeId: 'NavigationTree',

    fields: [{
        name: 'text'
    }],

    root: {
        expanded: true,
        children: [
            {
                text: '首页',
                iconCls: 'x-fa fa-home',
                //rowCls: 'nav-tree-badge nav-tree-badge-new',
                viewType: 'admindashboard',
                routeId: 'dashboard', // routeId defaults to viewType
                leaf: true
	            },{
                text: '人事部人员信息审核',
                iconCls: 'x-fa fa-street-view',
                viewType: 'authenticationApproveGrid',
                leaf: true
            },{
                text: '员工信息管理模块',
                iconCls: 'x-fa fa-address-book',
                expanded: false,
                selectable: false,

                children: [
                {
                        text: '员工信息管理',
                        iconCls: 'x-fa fa-address-book-o',
                        viewType: 'employee',
                        leaf: true
                },
                {
                        text: '员工信息审批管理',
                        iconCls: 'x-fa fa-address-book-o',
                        viewType: 'employeeApproveCenterPanel',
                        leaf: true
                },
                {
                        text: '人员调动管理',
                        iconCls: 'x-fa fa-exchange',
                        viewType: 'employeePositionInfo',
                        leaf: true
                },
                {
                        text: '劳动合同管理',
                        iconCls: 'x-fa  fa-address-card-o',
                        viewType: 'laborContract',
                        leaf: true
                },
                {
                        text: '劳动合同审批管理',
                        iconCls: 'x-fa  fa-address-card-o',
                        viewType: 'laborContractApproveCenterPanel',
                        leaf: true
                },
                {
                        text: '档案管理',
                        iconCls: 'x-fa fa-address-card',
                        viewType: 'archives',
                        leaf: true
                },
                {
                        text: '档案审批管理',
                        iconCls: 'x-fa fa-address-card',
                        viewType: 'archivesApproveCenterPanel',
                        leaf: true
                }]
        },
        {
                text: '部门信息管理模块',
                iconCls: 'x-fa  fa-sitemap',
                expanded: false,
                selectable: false,

                children: [
                {
                        text: '部门信息管理',
                        iconCls: 'x-fa fa-list-ul',
                        viewType: 'department',
                        leaf: true
                },
                {
                        text: '部门信息审批管理',
                        iconCls: 'x-fa fa-list-ul',
                        viewType: 'departmentApproveCenterPanel',
                        leaf: true
                },
                {
                        text: '岗位信息管理',
                        iconCls: 'x-fa fa-list-alt',
                        viewType: 'position',
                        leaf: true
                },
                {
                        text: '岗位信息审批管理',
                        iconCls: 'x-fa fa-list-alt',
                        viewType: 'positionApproveCenterPanel',
                        leaf: true
                }]
        },
        {
                text: '招聘信息管理模块',
                iconCls: 'x-fa fa-file-text',
                expanded: false,
                selectable: false,

                children: [
                {
                        text: '招聘需求管理',
                        iconCls: 'x-fa fa-file-text-o ',
                        viewType: 'recruitmentDemand',
                        leaf: true
                },
                {
                        text: '简历管理',
                        iconCls: 'x-fa fa-vcard',
                        viewType: 'resume',
                        leaf: true
                },
                {
                        text: '试题内容',
                        iconCls: 'x-fa  fa-list-ol',
                        viewType: 'writtenExaminationContent',
                        leaf: true
                },
                {
                        text: '试题详情',
                        iconCls: 'x-fa  fa-list-ol',
                        viewType: 'examinationQuestions',
                        leaf: true
                },
                {
                        text: '笔试管理',
                        iconCls: 'x-fa  fa-pencil-square-o',
                        viewType: 'writtenExamination',
                        leaf: true
                },
                {
                        text: '面试管理',
                        iconCls: 'x-fa fa-user',
                        viewType: 'interview',
                        leaf: true
                }]
        },
        {
                text: '培训信息管理模块',
                iconCls: 'x-fa fa-group',
                expanded: false,
                selectable: false,

                children: [
                {
                        text: '部门培训管理',
                        iconCls: 'x-fa  fa-user-circle-o',
                        viewType: 'trainingInfo',
                        leaf: true
                },
                {
                        text: '员工培训管理',
                        iconCls: 'x-fa fa-male',
                        viewType: 'trainingInfo',
                        leaf: true
                },
                {
                        text: '培训反馈管理',
                        iconCls: 'x-fa fa-reply',
                        viewType: 'trainingFeedback',
                        leaf: true
                }]
        },
        {
                text: '绩效信息管理模块',
                iconCls: 'x-fa fa-line-chart',
                expanded: false,
                selectable: false,

                children: [
                {
                        text: '考勤管理',
                        iconCls: 'x-fa fa-calendar-check-o',
                        viewType: 'attendance',
                        leaf: true
                },
                {
                        text: '请假管理',
                        iconCls: 'x-fa  fa-calendar-minus-o',
                        viewType: 'leaveDetail',
                        leaf: true
                },
                {
                        text: '考核标准管理',
                        iconCls: 'x-fa  fa-navicon',
                        viewType: 'assessmentStandard',
                        leaf: true
                },
                {
                        text: '考核结果管理',
                        iconCls: 'x-fa fa-align-justify',
                        viewType: 'employeeAssessment',
                        leaf: true
                },
                {
                        text: '优秀团队管理',
                        iconCls: 'x-fa  fa-slideshare',
                        viewType: 'greatTeam',
                        leaf: true
                }]
        },
        {
                text: '薪酬信息管理模块',
                iconCls: 'x-fa fa-rmb',
                expanded: false,
                selectable: false,

                children: [
                {
                        text: '员工每月工资管理',
                        iconCls: 'x-fa fa-jpy',
                        viewType: 'salaryDetail',
                        leaf: true
                },
               {
                        text: '员工奖惩记录管理',
                        iconCls: 'x-fa fa-star-half-o',
                        viewType: 'rewardPunishment',
                        leaf: true
               },
               {
                        text: '员工报销记录管理',
                        iconCls: 'x-fa fa-ticket',
                        viewType: 'expenseAccount',
                        leaf: true
		}]}/*,
		{
                text: 'Login',
                iconCls: 'x-fa fa-check',
                viewType: 'login',
                leaf: true
           }*/
        ]
    }
});
