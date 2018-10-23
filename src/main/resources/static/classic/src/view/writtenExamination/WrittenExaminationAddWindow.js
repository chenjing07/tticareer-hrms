Ext.define('Admin.view.writtenExamination.WrittenExaminationAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.writtenExaminationAddWindow',

	
    height: 500,
    minHeight: 200,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'WrittenExamination Add Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add WrittenExamination Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },  {
            xtype: 'textfield',
            fieldLabel: 'Resume Id',
            name:'resumeId'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Exam Content Id',
            name:'examContentId'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Exam Start',
            name:'examStart',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Exam End',
            name:'examEnd',
            format: 'Y/m/d H:i:s'
        },{
            xtype: 'textfield',
            fieldLabel: 'Exam Score',
            name:'examScore'
        },{
            xtype: 'combobox',
            fieldLabel: 'Exam Result',
            name: 'examResult',
            bind: '{examResult}',     
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '落选', value: '0' },
	  			{ name: '一面', value: '1' }
		    ]
		}),
        displayField: 'name',
        valueField:'value',
        selectOnFocus:false,
        editable: false,
        queryMode: 'local',
        emptyText: 'Exam Result'
        },{
            xtype: 'datefield',
            fieldLabel: 'Create Time',
            name:'createTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Note',
            name:'note'
        }
	]
    }],
    buttons:  [{
        xtype: 'button',
        text: 'Submit',
        handler: 'writtenExaminationAddSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
