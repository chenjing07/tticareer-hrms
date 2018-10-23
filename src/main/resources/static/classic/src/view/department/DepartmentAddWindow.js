Ext.define('Admin.view.department.DepartmentAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.departmentAddWindow',

	
    height: 300,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Department Add Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add Department Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'SuperiorDepartmentId',
            name:'superiorDepartmentId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'DepartmentNumber',
            name:'departmentNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: 'DepartmentName',
            name:'departmentName'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'DepartmentIntroduction',
            name:'departmentIntroduction'
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
            name:'checkStatus'
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
