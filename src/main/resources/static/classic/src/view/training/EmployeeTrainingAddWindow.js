Ext.define('Aria.view.training.EmployeeTrainingAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeeTrainingAddWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '添加培训信息',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add Training Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        },{
            xtype: 'textfield',
            fieldLabel: '讲师',
            name:'lecturer'
        }, {
            xtype: 'datefield',
            fieldLabel: '培训开始时间',
            name:'time',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: '培训计划时长',
            name:'duration'
        },{
            xtype: 'textfield',
            fieldLabel: '培训目的',
            name:'purpose'
        },{
            xtype: 'textfield',
            fieldLabel: '计划费用',
            name:'cost'
        },{
            xtype: 'textfield',
            fieldLabel: '培训地点',
            name:'place'
        },{
            xtype: 'textfield',
            fieldLabel: '培训内容',
            name:'content'
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }
]
    }],
   
    buttons: ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'submitAddForm'
    },' ',' ',' ',' ',{
        xtype: 'button',
        text: 'Close',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
