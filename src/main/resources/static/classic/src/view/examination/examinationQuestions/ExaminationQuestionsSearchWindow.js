Ext.define('Admin.view.examination.examinationQuestions.ExaminationQuestionsSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.examinationQuestionsSearchWindow',

    height: 300,
    minHeight: 200,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'ExaminationQuestions Search Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
    	scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Search ExaminationQuestions Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: 'State',
            name:'state'
        },
        {
            xtype: 'datefield',
            fieldLabel: 'From',
            name:'createTimeStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'To',
            name:'createTimeEnd',
            format: 'Y/m/d H:i:s'
        }
	]
    }],
    buttons:  ['-\x3e',{
        xtype: 'button',
        text: 'Submit',
        handler: 'examinationQuestionsSearchSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    },'-\x3e']
});
