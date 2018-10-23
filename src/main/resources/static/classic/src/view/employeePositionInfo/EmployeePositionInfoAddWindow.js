Ext.define('Admin.view.employeePositionInfo.EmployeePositionInfoAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeePositionInfoAddWindow',

	
    height: 300,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'EmployeePositionInfo Add Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add EmployeePositionInfo Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'EmployeeId',
            name:'employeeId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'PositionId',
            name:'positionId'
        },
        {
            xtype: 'datefield',
            fieldLabel: 'ArrivePost',
            name:'arrivePost',
			format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'LeavePost',
            name:'leavePost',
			format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'TransferReason',
            name:'transferReason'
        }, {
            xtype: 'textfield',
            fieldLabel: 'LeaveOpinion',
            name:'leaveOpinion'
        }, {
            xtype: 'textfield',
            fieldLabel: 'ArriveOpinion',
            name:'arriveOpinion'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'State',
            name:'state'
        }, {
            xtype: 'datefield',
            fieldLabel: 'CreateTime',
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
