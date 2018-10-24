Ext.define('Aria.view.attendance.LateEarlyEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.lateEarlyEditWindow',
    height: 400,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '修改迟到早退信息',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Edit LateEarly',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        },{
            xtype: 'datefield',
            fieldLabel: '迟到早退日期',
            name:'lateEarlyTime',
            format: 'Y/m/d H:i:s'
        },{
            xtype: 'textfield',
            fieldLabel: '迟到早退原因',
            name:'lateEarlyReason'
        },{
            xtype: 'textfield',
            fieldLabel: '状态',
            name:'state'
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }]
    }],
   
    buttons: ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'submitLateEarlyEditForm'
    },' ',' ',' ',' ',{
        xtype: 'button',
        text: 'Close',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
