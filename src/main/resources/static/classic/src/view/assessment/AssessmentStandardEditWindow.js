Ext.define('Aria.view.assessment.AssessmentStandardEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.assessmentStandardEditWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '修改考核标准信息',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Edit AssessmentStandard',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '岗位编号',
            name:'positionNumber'
        },{
            xtype: 'textfield',
            fieldLabel: '工作业绩说明',
            name:'workResult'
        },{
            xtype: 'textfield',
            fieldLabel: '工作态度说明',
            name:'attitude'
        },{
            xtype: 'textfield',
            fieldLabel: '工作质量说明',
            name:'quality'
        },{
            xtype: 'textfield',
            fieldLabel: '工作技能说明',
            name:'skill'
        },{
            xtype: 'textfield',
            fieldLabel: '考核计算方法说明',
            name:'calculationWay'
        },{
            xtype: 'textfield',
            fieldLabel: '考核分类说明',
            name:'assessmentType'
        },{
            xtype: 'textfield',
            fieldLabel: '结果级别划分说明',
            name:'resultLevel'
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }]
    }],
   
    buttons: ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'submitAssessmentStandardEditForm'
    },' ',' ',' ',' ',{
        xtype: 'button',
        text: 'Close',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
