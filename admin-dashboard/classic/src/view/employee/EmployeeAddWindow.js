Ext.define('Admin.view.employee.EmployeeAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeeAddWindow',

    height: 200,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Employee Add Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
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
            fieldLabel: 'Employee Number',
            name:'employee_number'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Password',
            name:'password'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Real Name',
            name:'real_name'
        }, {
            xtype: 'textfield',
            fieldLabel: 'id Card Number',
            name:'id_card_number'
        }, {
            xtype: 'textfield',
            fieldLabel: 'id Card Picture',
            name:'id_card_picture'
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
            name:'native_place'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Registered Address',
            name:'registered_address'
        }, {
            xtype: 'textfield',
            fieldLabel: 'House Address',
            name:'house_address'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Education',
            name:'education'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Academic Degree',
            name:'academic_degree'
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
            name:'graduated_school'
        },
        {
            xtype: 'datefield',
            fieldLabel: 'Graduated Time',
            name:'graduated_time',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Political Status',
            name:'political_status'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Marital Status',
            name:'marital_status'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Recruitment Source',
            name:'recruitment_source'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Account Bank',
            name:'account_bank'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Account Number',
            name:'account_number'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Phone Number',
            name:'phone_number'
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
            name:'emergency_contact_name'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Emergency Contact Relationship',
            name:'emergency_contact_relationship'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Emergency Contact Numbe',
            name:'emergency_contact_numbe'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Emergency Contact Name',
            name:'emergency_contact_name'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Iswork',
            name:'iswork'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Work Start',
            name:'work_start',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Work End',
            name:'work_end',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Practice Start',
            name:'practice_start',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Practice End',
            name:'practice_end',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'State',
            name:'state'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Create Time',
            name:'create_time',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Check Satus',
            name:'check_satus'
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
