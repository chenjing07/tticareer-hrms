Ext.define('Aria.view.attendance.LateEarlyAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.lateEarlyAddWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '添加迟到早退信息',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add LateEarly',
        items: [{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        },{
            xtype: 'radiogroup',
            id: 'state',
            fieldLabel: '状态',
            items: [{
                boxLabel: '迟到',
                name      : 'state',
                inputValue: '1',
                checked: true
            }, {
                boxLabel: '早退',
                name      : 'state',
                inputValue: '2'
            }]
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
            fieldLabel: '备注',
            name:'note'
        }]
    }],
   
    buttons: ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'submitLateEarlyAddForm'
    },' ',' ',' ',' ',{
        xtype: 'button',
        text: 'Close',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
