Ext.define('Admin.view.laborContract.LaborContractAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.laborContractAddWindow',

	
    height: 300,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'LaborContract Add Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add LaborContract Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'EmployerName',
            name:'employerName'
        }, {
            xtype: 'textfield',
            fieldLabel: 'EmployeeId',
            name:'employeeId'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'ContractTimeLimit',
            name:'contractTimeLimit'
        }, {
            xtype: 'datefield',
            fieldLabel: 'ContractStart',
            name:'contractStart',
            format: 'Y/m/d H:i:s'
        },  {
            xtype: 'datefield',
            fieldLabel: 'ContractEnd',
            name:'contractEnd',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'WorkContent',
            name:'workContent'
        }, {
            xtype: 'textfield',
            fieldLabel: 'WorkPlace',
            name:'workPlace'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'LaborProtection',
            name:'laborProtection'
        }, {
            xtype: 'textfield',
            fieldLabel: 'LaborConditions',
            name:'laborConditions'
        }, {
            xtype: 'textfield',
            fieldLabel: 'LaborReward',
            name:'laborReward'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'DefaultResponsibility',
            name:'defaultResponsibility'
        }, {
            xtype: 'textfield',
            fieldLabel: 'SocialInsurance',
            name:'socialInsurance'
        }, {
            xtype: 'textfield',
            fieldLabel: 'ContractChange',
            name:'contractChange'
        },
        {
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
