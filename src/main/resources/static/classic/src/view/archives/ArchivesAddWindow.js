Ext.define('Admin.view.archives.ArchivesAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.archivesAddWindow',

	
    height: 300,
    minHeight: 10,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Archives Add Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add Archives Information',
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
            xtype: 'datefield',
            fieldLabel: 'InTime',
            name:'inTime',
            format: 'Y/m/d H:i:s'
        },  {
            xtype: 'datefield',
            fieldLabel: 'OutTime',
            name:'outTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'ArchivesSource',
            name:'archivesSource'
        }, {
            xtype: 'textfield',
            fieldLabel: 'ArchivesDestination',
            name:'archivesDestination'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'ArchivesChange',
            name:'archivesChange'
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
