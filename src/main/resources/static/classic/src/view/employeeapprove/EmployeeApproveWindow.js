Ext.define('Admin.view.employeeapprove.EmployeeApproveWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeeApproveWindow',

    y:10,
    height: 400,
    //minHeight: 10,
    //minWidth: 300,
    width: 500,
    scrollable: true,
    title: '审批窗口',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add Employee Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '工号',
            name:'userName',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '密码',
            name:'password',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '真实姓名',
            name:'realName',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '身份证号',
            name:'idCardNumber',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '身份证图片存放地址',
            name:'idCardPicture',
			readOnly: true
        },
        {
            xtype: 'datefield',
            fieldLabel: '出生日期',
            name:'birthday',
            format: 'Y/m/d H:i:s',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '性别',
            name:'gender',
			readOnly: true
			
        }, {
            xtype: 'textfield',
            fieldLabel: '民族',
            name:'nation',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '籍贯',
            name:'nativePlace',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '户口地址',
            name:'registeredAddress',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '家庭住址',
            name:'houseAddress',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '学历',
            name:'education',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '学位',
            name:'academicDegree',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '专业',
            name:'major',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '系别',
            name:'tie',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '毕业院校',
            name:'graduatedSchool',
			readOnly: true
        },
        {
            xtype: 'datefield',
            fieldLabel: '毕业时间',
            name:'graduatedTime',
            format: 'Y/m/d H:i:s',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '政治面貌',
            name:'politicalStatus',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '婚姻状况',
            name:'maritalStatus',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '招聘来源',
            name:'recruitmentSource',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '开户银行',
            name:'accountBank',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '工资账户',
            name:'accountNumber',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '手机号码',
            name:'phoneNumber',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '邮箱',
            name:'email',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'QQ号码',
            name:'qq',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '微信号',
            name:'wechat',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'MSN',
            name:'msn',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '紧急联系人姓名',
            name:'emergencyContactName',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '紧急联系人关系',
            name:'emergencyContactRelationship',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '紧急联系人电话',
            name:'emergencyContactNumber',
			readOnly: true
        }, {
            xtype: 'datefield',
            fieldLabel: '入职时间',
            name:'workStart',
            format: 'Y/m/d H:i:s',
			readOnly: true
        }, {
            xtype: 'datefield',
            fieldLabel: '离职时间',
            name:'workEnd',
            format: 'Y/m/d H:i:s',
			readOnly: true
        }, {
            xtype: 'datefield',
            fieldLabel: '实习开始时间',
            name:'practiceStart',
            format: 'Y/m/d H:i:s',
			readOnly: true
        }, {
            xtype: 'datefield',
            fieldLabel: '实习结束时间',
            name:'practiceEnd',
            format: 'Y/m/d H:i:s',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '在职状态',
            name:'iswork',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '状态',
            name:'state',
			readOnly: true
        }, {
            xtype: 'datefield',
            fieldLabel: '创建日期',
            name:'createTime',
            format: 'Y/m/d H:i:s',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '审查状态',
            name:'checkSatus',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note',
			readOnly: true
        }]
    }],
    buttons:  ['->',{
        xtype: 'button',
        text: 'Pass',
        handler: 'passApproveButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'NoPass',
        handler: 'nopassApproveButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});

