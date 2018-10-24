Ext.define('Admin.view.archives.ArchivesEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.archivesEditWindow',

     y:10,
    height:400,
    //minHeight: 10,
    //minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Archives Edit Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add Archives Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'combo',
            fieldLabel: '员工Id',
            name:'employeeId',
			store : Ext.create('Ext.data.Store',{
				fields:[
					{type:'int',name:'employeeId'},
					{type:'string',name:'employeeName'}
				],
				 proxy: {
					type: 'rest',
					url: '/employee/getEmployeeIdAndName',	//mvc url  xxx.json
					reader:{
						type:'json',
						rootProperty:'data',
						totalProperty: 'totalElements'
					},
						writer: {
						type: 'json'
					},
						simpleSortMode: true
				},
				autoLoad:true,
				autoSync:true
			}),
			mode : 'local',
			allowBlank : false,
			editable : false, 
			valueField : 'employeeId',
			displayField : 'employeeName'
        }, {
            xtype: 'datefield',
            fieldLabel: '转入时间',
            name:'inTime',
            format: 'Y/m/d H:i:s'
        },  {
            xtype: 'datefield',
            fieldLabel: '转出时间',
            name:'outTime',
            format: 'Y/m/d H:i:s'
        }, {
            xtype: 'textfield',
            fieldLabel: '档案来处',
            name:'archivesSource'
        }, {
            xtype: 'textfield',
            fieldLabel: '档案去处',
            name:'archivesDestination'
        },
        {
            xtype: 'textfield',
            fieldLabel: '档案变更说明',
            name:'archivesChange'
        }, /*{
            xtype: 'textfield',
            fieldLabel: '状态',
            name:'state'
        },*/ {
            xtype: 'datefield',
            fieldLabel: '录入时间',
            name:'createTime',
            format: 'Y/m/d H:i:s'
        },/* {
            xtype: 'textfield',
            fieldLabel: '审核状态',
            name:'checkStatus',
        },*/ {
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }
	]
    }],
    buttons:  ['->',{
        xtype: 'button',
        text: 'Submit',
        handler: 'editSubmitButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
