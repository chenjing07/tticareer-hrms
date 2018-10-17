Ext.define('Admin.view.resume.ResumeEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.resumeEditWindow',

    height: 200,
    minHeight: 100,
    minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Resume Edit Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Edit Resume Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        },  {
            xtype: 'textfield',
            fieldLabel: 'Application Name',
            name:'applicationName'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Expected Position',
            name:'expectedPosition'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Id Card Number',
            name:'idCardNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Id Card Picture',
            name:'idCardPicture'
        },{
            xtype: 'datefield',
            fieldLabel: 'Birthday',
            name:'birthday',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'combobox',
            name: 'gender',
            bind: '{gender}',     
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '男', value: '1' },
	  			{ name: '女', value: '0' }
		    ]
		}),
        displayField: 'name',
        valueField:'value',
        selectOnFocus:false,
        editable: false,
        queryMode: 'local',
        emptyText: 'Gender'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Nation',
            name:'nation'
        },
        {
            xtype: 'textfield',
            fieldLabel: 'Native Place',
            name:'nativePlace'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Registered Address',
            name:'registeredAddress'
        }, {
            xtype: 'textfield',
            fieldLabel: 'House Address',
            name:'houseAddress'
        },
        {
            xtype: 'combobox',
            name: 'politicalStatus',
            bind: '{politicalStatus}',     
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '群众', value: '0' },
	  			{ name: '中共党员', value: '1' },
	  			{ name: '中共预备党员', value: '2' },
	  			{ name: '共青团员', value: '3' },
	  			{ name: '民革党员', value: '4' },
	  			{ name: '民盟盟员', value: '5' },
	  			{ name: '民建会员', value: '6' },
	  			{ name: '民进会员', value: '7' },
	  			{ name: '农工党党员', value: '8' },
	  			{ name: '致公党党员', value: '9' },
	  			{ name: '九三学社社员', value: '10' },
	  			{ name: '台盟盟员', value: '11' },
	  			{ name: '无党派人士', value: '12' }
		    ]
		}),
        displayField: 'name',
        valueField:'value',
        selectOnFocus:false,
        editable: false,
        queryMode: 'local',
        emptyText: 'Political Status'
        }, {
            xtype: 'combobox',
            name: 'maritalStatus',
            bind: '{maritalStatus}',     
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '已婚', value: '1' },
	  			{ name: '未婚', value: '0' }
		    ]
		}),
        displayField: 'name',
        valueField:'value',
        selectOnFocus:false,
        editable: false,
        queryMode: 'local',
        emptyText: 'Marital Status'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Phone Number',
            name:'phoneNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Email',
            name:'email'
        }, {
            xtype: 'textfield',
            fieldLabel: 'QQ',
            name:'qq'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Education',
            name:'education'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Academic Degree',
            name:'academicDegree'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Major',
            name:'major'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Tie',
            name:'tie'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Graduated School',
            name:'graduatedSchool'
        },{
            xtype: 'datefield',
            fieldLabel: 'Graduated Time',
            name:'graduatedTime',
            format: 'Y/m/d H:i:s'
        },  {
            xtype: 'textfield',
            fieldLabel: 'Awards Received',
            name:'awardsReceived'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Language Level',
            name:'languageLevel'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Work Experience',
            name:'workExperience'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Hobbies',
            name:'hobbies'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Self Evaluation',
            name:'selfEvaluation'
        }, {
            xtype: 'combobox',
            name: 'state',
            bind: '{state}',     
            store:Ext.create("Ext.data.Store", {
		    fields: ["name", "value"],
		    data: [
		      	{ name: '待处理', value: '0' },
	  			{ name: '进入笔试', value: '1' },
	  			{ name: '落选', value: '2' }
		    ]
		}),
        displayField: 'name',
        valueField:'value',
        selectOnFocus:false,
        editable: false,
        queryMode: 'local',
        emptyText: 'State'
        }, {
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
        handler: 'resumeEditSubmitButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
