Ext.define('Admin.view.position.PositionEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.positionEditWindow',

     y:10,
    height: 400,
    //minHeight: 10,
    //minWidth: 300,
    width: 500,
    scrollable: true,
    title: 'Position Edit Window',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add Position Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'combo',
            fieldLabel: '部门Id',
            name:'departmentId',
			store : Ext.create('Ext.data.Store',{
				fields:[
					{type:'int',name:'departmentId'},
					{type:'string',name:'departmentName'}
				],
				 proxy: {
					type: 'rest',
					url: '/department/getDepartmentIdAndName',	//mvc url  xxx.json
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
			valueField : 'departmentId',
			displayField : 'departmentName'
        }, {
            xtype: 'textfield',
            fieldLabel: '岗位编号',
            name:'positionNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: '岗位名称',
            name:'positionName'
        },{
            xtype: 'combo',
            fieldLabel: '上级岗位Id',
            name:'superiorPositionid',
			store : Ext.create('Ext.data.Store',{
				fields:[
					{type:'int',name:'positionId'},
					{type:'string',name:'positionName'}
				],
				 proxy: {
					type: 'rest',
					url: '/position/getPositionIdAndName',	//mvc url  xxx.json
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
			valueField : 'positionId',
			displayField : 'positionName'
        }, 
        {
            xtype: 'textfield',
            fieldLabel: '岗位简介',
            name:'positionIntroduction'
        },/* {
            xtype: 'textfield',
            fieldLabel: 'State',
            name:'state'
        },*/ {
            xtype: 'datefield',
            fieldLabel: '创建时间',
            name:'createTime',
            format: 'Y/m/d H:i:s'
        }, /*{
            xtype: 'textfield',
            fieldLabel: 'Check Satus',
            name:'checkStatus'
        }, */{
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
