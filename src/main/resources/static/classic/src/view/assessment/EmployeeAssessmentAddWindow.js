Ext.define('Aria.view.assessment.EmployeeAssessmentAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.employeeAssessmentAddWindow',
    height: 500,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: '添加员工考核信息',
    closable: true,
    constrain: true,
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add EmployeeAssessment',
        items: [{
            xtype: 'textfield',
            fieldLabel: '员工编号',
            name:'userName'
        },{
            xtype: 'radiogroup',
            id: 'assessmentType',
            fieldLabel: '考核分类',
            items: [{
                boxLabel: '日常考核',
                name      : 'assessmentType',
                inputValue: 1,
                checked: true
            }, {
                boxLabel: '定期考核',
                name      : 'assessmentType',
                inputValue: 2
            }, {
                boxLabel: '长期考核',
                name      : 'assessmentType',
                inputValue: 3
            }, {
                boxLabel: '不定期考核',
                name      : 'assessmentType',
                inputValue: 4
            }]
        },{
            xtype: 'radiogroup',
            id: 'workResult',
            fieldLabel: '工作业绩',
            items: [{
                boxLabel: '优秀',
                name      : 'workResult',
                inputValue: 1,
                checked: true
            }, {
                boxLabel: '良好',
                name      : 'workResult',
                inputValue: 2
            }, {
                boxLabel: '及格',
                name      : 'workResult',
                inputValue: 3
            }, {
                boxLabel: '不及格',
                name      : 'workResult',
                inputValue: 4
            }]
        },{
            xtype: 'radiogroup',
            id: 'attitude',
            fieldLabel: '工作态度',
            items: [{
                boxLabel: '优秀',
                name      : 'attitude',
                inputValue: 1,
                checked: true
            }, {
                boxLabel: '良好',
                name      : 'attitude',
                inputValue: 2
            }, {
                boxLabel: '及格',
                name      : 'attitude',
                inputValue: 3
            }, {
                boxLabel: '不及格',
                name      : 'attitude',
                inputValue: 4
            }]
        },{
            xtype: 'radiogroup',
            id: 'quality',
            fieldLabel: '工作质量',
            items: [{
                boxLabel: '优秀',
                name      : 'quality',
                inputValue: 1,
                checked: true
            }, {
                boxLabel: '良好',
                name      : 'quality',
                inputValue: 2
            }, {
                boxLabel: '及格',
                name      : 'quality',
                inputValue: 3
            }, {
                boxLabel: '不及格',
                name      : 'quality',
                inputValue: 4
            }]
        },{
            xtype: 'radiogroup',
            id: 'skill',
            fieldLabel: '工作技能',
            items: [{
                boxLabel: '优秀',
                name      : 'skill',
                inputValue: 1,
                checked: true
            }, {
                boxLabel: '良好',
                name      : 'skill',
                inputValue: 2
            }, {
                boxLabel: '及格',
                name      : 'skill',
                inputValue: 3
            }, {
                boxLabel: '不及格',
                name      : 'skill',
                inputValue: 4
            }]
        },{
            xtype: 'radiogroup',
            id: 'assessmentResult',
            fieldLabel: '考核结果',
            items: [{
                boxLabel: '优秀',
                name      : 'assessmentResult',
                inputValue: 1,
                checked: true
            }, {
                boxLabel: '良好',
                name      : 'assessmentResult',
                inputValue: 2
            }, {
                boxLabel: '及格',
                name      : 'assessmentResult',
                inputValue: 3
            }, {
                boxLabel: '不及格',
                name      : 'assessmentResult',
                inputValue: 4
            }]
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
        handler: 'submitEmployeeAssessmentAddForm'
    },' ',' ',' ',' ',{
        xtype: 'button',
        text: 'Close',
        handler: function(btn) {
            btn.up('window').close();
        }
    },'->']
});
