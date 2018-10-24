Ext.define('Aria.view.training.TrainingFeedbackEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.trainingFeedbackEditWindow',
    height: 400,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '修改培训反馈信息',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Edit Training Feedback',
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
            xtype: 'textfield',
            fieldLabel: '培训编号',
            name:'trainingInfoId'
        },{
            xtype: 'textfield',
            fieldLabel: '反馈信息',
            name:'trainingFeedback'
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }]
    }],
   
    buttons: ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'submitEditForm'
    },' ',' ',' ',' ',{
        xtype: 'button',
        text: 'Close',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
