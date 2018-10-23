Ext.define('Admin.view.position.PositionAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.positionAddWindow',

	
    height: 300,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Position Add Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add Position Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'DepartmentId',
            name:'departmentId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'PositionNumber',
            name:'positionNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: 'PositionName',
            name:'positionName'
        },{
            xtype: 'textfield',
            fieldLabel: 'SuperiorPositionid',
            name:'superiorPositionid'
        }, 
        {
            xtype: 'textfield',
            fieldLabel: 'PositionIntroduction',
            name:'positionIntroduction'
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
