Ext.define('Aria.view.assessment.EmployeeAssessmentEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeeAssessmentEditWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '修改员工考核信息',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Edit EmployeeAssessment',
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
            fieldLabel: '考核分类',
            name:'assessmentType'
        },{
            xtype: 'textfield',
            fieldLabel: '工作业绩',
            name:'workResult'
        },{
            xtype: 'textfield',
            fieldLabel: '工作态度',
            name:'attitude'
        },{
            xtype: 'textfield',
            fieldLabel: '工作质量',
            name:'quality'
        },{
            xtype: 'textfield',
            fieldLabel: '工作技能',
            name:'skill'
        },{
            xtype: 'textfield',
            fieldLabel: '考核结果',
            name:'assessmentResult'
        },{
            xtype: 'textfield',
            fieldLabel: '评价',
            name:'evaluate'
        },{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }]
    }],
   
    buttons: ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'submitEmployeeAssessmentEditForm'
    },' ',' ',' ',' ',{
        xtype: 'button',
        text: 'Close',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
