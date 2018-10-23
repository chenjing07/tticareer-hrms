Ext.define('Admin.view.examination.examinationQuestions.ExaminationQuestionsAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.examinationQuestionsAddWindow',

	
    height: 500,
    minHeight: 200,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'ExaminationQuestions Add Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add ExaminationQuestions Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },  {
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
            fieldLabel: 'Difficulty Level',
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
            xtype: 'combobox',
            fieldLabel: 'Category',
            name: 'category',
            bind: '{category}',     
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '选择题', value: '1' },
	  			{ name: '填空题', value: '2' },
	  			{ name: '问答题', value: '3' },
	  			{ name: '计算题', value: '4' }	
		    ]
		}),
        displayField: 'name',
        valueField:'value',
        selectOnFocus:false,
        editable: false,
        queryMode: 'local',
        emptyText: 'Category'
        },{
            xtype: 'textfield',
            fieldLabel: 'Explanation',
            name:'explanation'
        },{
            xtype: 'combobox',
            fieldLabel: 'State',
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
    buttons:  [{
        xtype: 'button',
        text: 'Submit',
        handler: 'examinationQuestionsAddSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
