Ext.define('Admin.view.writtenExamination.WrittenExaminationSearchWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.writtenExaminationSearchWindow',

    height: 300,
    minHeight: 200,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'WrittenExamination Search Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Search WrittenExamination Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: 'Exam Result',
            name:'examResult'
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
        handler: 'writtenExaminationSearchSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    },'-\x3e']
});
