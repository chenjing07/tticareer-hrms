Ext.define('Admin.view.employee.EmployeeAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeeAddWindow',

	
     y:10,
    height: 400,
    //minHeight: 10,
    //minWidth: 300,
    width: 500,
    scrollable: true,
    title: '新增员工信息',
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
            fieldLabel: '<span style="color:red;">*</span>工号',
            name:'userName'
        }, {
            xtype: 'textfield',
            fieldLabel: '密码',
            name:'password',
			value:'password'
        },
        {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>真实姓名',
            name:'realName'
        }, {
            xtype: 'textfield',
            fieldLabel: '身份证号',
            name:'idCardNumber'
        },/* {
            xtype: 'textfield',
            fieldLabel: 'id Card Picture',
            name:'idCardPicture'
        },*/
        {
            xtype: 'datefield',
            fieldLabel: '<span style="color:red;">*</span>出生年月',
            name:'birthday',
            format: 'Y/m/d H:i:s'
        }, {
			xtype : 'combo',
			fieldLabel : '<span style="color:red;">*</span>性别',
			allowBlank : false,
			editable : false,
			name:'gender',
			store : [['0', '女'], ['1', '男']],
			value : 0
        }, {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>民族',
            name:'nation'
        },
        {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>籍贯',
            name:'nativePlace'
        }, {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>户口地址',
            name:'registeredAddress'
        }, {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>家庭住址',
            name:'houseAddress'
        },
        {
            xtype: 'textfield',
            fieldLabel: '学历',
            name:'education'
        }, {
            xtype: 'textfield',
            fieldLabel: '学位',
            name:'academicDegree'
        }, {
            xtype: 'textfield',
            fieldLabel: '专业',
            name:'major'
        },
        {
            xtype: 'textfield',
            fieldLabel: '系别',
            name:'tie'
        }, {
            xtype: 'textfield',
            fieldLabel: '毕业院校',
            name:'graduatedSchool'
        },
        {
            xtype: 'datefield',
            fieldLabel: '毕业时间',
            name:'graduatedTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'combo',
            fieldLabel: '<span style="color:red;">*</span>政治面貌',
            name:'politicalStatus',
			allowBlank : false,
			editable : false,
			store : [['0', '群众'], ['1', '中共党员'],['2', '中共预备党员'], ['3', '共青团员'], ['4', '其他']],
			value : 0
        }, {
			xtype : 'combo',
			fieldLabel : '<span style="color:red;">*</span>婚姻状况',
			allowBlank : false,
			editable : false,
			name:'maritalStatus',
			store : [['0', '未婚'], ['1', '已婚']],
			value : 0
        },
        {
            xtype: 'combo',
            fieldLabel: '<span style="color:red;">*</span>招聘来源',
            name:'recruitmentSource',
			allowBlank : false,
			editable : false,
			store : [['0', '简历应聘'], ['1', '招聘网站'], ['2', '招聘网站']]
        }, {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>开户银行',
            name:'accountBank'
        }, {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>工资账户',
            name:'accountNumber'
        },
        {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>手机号',
            name:'phoneNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>邮箱',
            name:'email'
        }, {
            xtype: 'textfield',
            fieldLabel: 'QQ号码',
            name:'qq'
        },
        {
            xtype: 'textfield',
            fieldLabel: '微信号',
            name:'wechat'
        }, {
            xtype: 'textfield',
            fieldLabel: 'MSN',
            name:'msn'
        }, {
            xtype: 'textfield',
            fieldLabel: '紧急联系人姓名',
            name:'emergencyContactName'
        },
        {
            xtype: 'textfield',
            fieldLabel: '紧急联系人关系',
            name:'emergencyContactRelationship'
        }, {
            xtype: 'textfield',
            fieldLabel: '紧急联系人电话',
            name:'emergencyContactNumber'
        },
        {
			xtype : 'combo',
			fieldLabel : '<span style="color:red;">*</span>工作状态',
			allowBlank : false,
			editable : false,
			name:'iswork',
			store : [['0', '离职'], ['1', '正式'], ['2', '实习']],
			value : 0
        }, {
            xtype: 'datefield',
            fieldLabel: '入职时间',
            name:'workStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '离职时间',
            name:'workEnd',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '实习开始时间',
            name:'practiceStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: '实习结束时间',
            name:'practiceEnd',
            format: 'Y/m/d H:i:s'
        }, /*{
            xtype: 'textfield',
            fieldLabel: 'State',
            name:'state'
        },*/ {
            xtype: 'datefield',
            fieldLabel: '<span style="color:red;">*</span>创建时间',
            name:'createTime',
            format: 'Y/m/d H:i:s'
        },/* {
            xtype: 'textfield',
            fieldLabel: 'Check Satus',
            name:'checkSatus'
        },*/ {
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }
	]
    }],
    buttons:  [{
        xtype: 'button',
        text: 'Submit',
		id:'employeeAddSubmit',
        handler: 'addSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
