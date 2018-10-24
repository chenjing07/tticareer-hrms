Ext.define('Aria.view.attendance.LeaveDetailAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.leaveDetailAddWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '添加请假信息',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add LeaveDetail',
        items: [{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        },{
            xtype: 'datefield',
            fieldLabel: '请假开始时间',
            name:'leaveStart',
            format: 'Y/m/d H:i:s'
        },{
            xtype: 'datefield',
            fieldLabel: '请假结束时间',
            name:'leaveEnd',
            format: 'Y/m/d H:i:s'
        },{
            xtype: 'textfield',
            fieldLabel: '请假天数',
            name:'leaveDays'
        },{
            xtype: 'textfield',
            fieldLabel: '请假原因',
            name:'reason'
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }]
    }],
   
    buttons: ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'submitLeaveDetailAddForm'
    },' ',' ',' ',' ',{
        xtype: 'button',
        text: 'Close',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
