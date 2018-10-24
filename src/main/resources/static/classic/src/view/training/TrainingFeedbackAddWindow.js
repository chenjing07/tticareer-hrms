Ext.define('Aria.view.training.TrainingFeedbackAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.trainingFeedbackAddWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '添加培训反馈信息',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add Training Feedback',
        items: [{
            xtype: 'textfield',
            fieldLabel: '培训编号',
            name:'trainingInfoId'
        },{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        },{
            xtype: 'textfield',
            fieldLabel: '反馈信息',
            name:'trainingFeedback'
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
