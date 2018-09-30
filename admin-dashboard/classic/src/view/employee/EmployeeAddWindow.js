Ext.define('Admin.view.employee.EmployeeAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeeAddWindow',

	
    height: 300,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Employee Add Window',
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
            fieldLabel: 'UserName',
            name:'userName'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Password',
            name:'password'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Real Name',
            name:'realName'
        }, {
            xtype: 'textfield',
            fieldLabel: 'id Card Number',
            name:'idCardNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: 'id Card Picture',
            name:'idCardPicture'
        },
        {
            xtype: 'datefield',
            fieldLabel: 'Birthday',
            name:'birthday',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Gender',
            name:'gender'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Nation',
            name:'nation'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Native Place',
            name:'nativePlace'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Registered Address',
            name:'registeredAddress'
        }, {
            xtype: 'textfield',
            fieldLabel: 'House Address',
            name:'houseAddress'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Education',
            name:'education'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Academic Degree',
            name:'academicDegree'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Major',
            name:'major'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Tie',
            name:'tie'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Graduated School',
            name:'graduatedSchool'
        },
        {
            xtype: 'datefield',
            fieldLabel: 'Graduated Time',
            name:'graduatedTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Political Status',
            name:'politicalStatus'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Marital Status',
            name:'maritalStatus'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Recruitment Source',
            name:'recruitmentSource'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Account Bank',
            name:'accountBank'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Account Number',
            name:'accountNumber'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Phone Number',
            name:'phoneNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Email',
            name:'email'
        }, {
            xtype: 'textfield',
            fieldLabel: 'QQ',
            name:'qq'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Wechat',
            name:'wechat'
        }, {
            xtype: 'textfield',
            fieldLabel: 'MSN',
            name:'msn'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Emergency Contact Name',
            name:'emergencyContactName'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Emergency Contact Relationship',
            name:'emergencyContactRelationship'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Emergency Contact NumbeR',
            name:'emergencyContactNumber'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Iswork',
            name:'iswork'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Work Start',
            name:'workStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Work End',
            name:'workEnd',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Practice Start',
            name:'practiceStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Practice End',
            name:'practiceEnd',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'State',
            name:'state'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Create Time',
            name:'createTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Check Satus',
            name:'checkSatus'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Note',
            name:'note'
        }
	]
    }],
    buttons:  [{
        xtype: 'button',
        text: 'Submit',
        handler: 'addSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
