Ext.define('Admin.view.examination.examinationQuestions.ExaminationQuestionsEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.examinationQuestionsEditWindow',

    height: 200,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'ExaminationQuestions Edit Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Edit ExaminationQuestions Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: 'Question',
            name:'question'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Answer',
            name:'answer'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Score',
            name:'score'
        }, {
            xtype: 'combobox',
            name: 'difficultyLevel',
            bind: '{difficultyLevel}',     
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '易', value: '0' },
	  			{ name: '中', value: '1' },
	  			{ name: '难', value: '2' }		
		    ]
		}),
        displayField: 'name',
        valueField:'value',
        selectOnFocus:false,
        editable: false,
        queryMode: 'local',
        emptyText: 'DifficultyLevel'
        },{
            xtype: 'textfield',
            fieldLabel: 'Category',
            name:'category'
        },{
            xtype: 'textfield',
            fieldLabel: 'Explanation',
            name:'explanation'
        },{
            xtype: 'combobox',
            name: 'state',
            bind: '{state}',     
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '冻结', value: '0' },
	  			{ name: '未使用', value: '1' },
	  			{ name: '使用', value: '2' },
	  			{ name: '有错误', value: '-1' }
		    ]
		}),
        displayField: 'name',
        valueField:'value',
        selectOnFocus:false,
        editable: false,
        queryMode: 'local',
        emptyText: 'State'
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
    buttons:  ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'examinationQuestionsEditSubmitButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
