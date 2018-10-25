Ext.define('Admin.view.department.DepartmentAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.departmentAddWindow',

	y:10,
    height: 380,
    //minHeight: 10,
    //minWidth: 300,
    width: 500,
    scrollable: true,
    title: '新增部门信息',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add Department Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
			xtype : 'combo',
			fieldLabel : '上级部门id',
			name:'superiorDepartmentId',
			//id:'departmentSuperior',
			
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
            fieldLabel: '<span style="color:red;">*</span>部门编号',
            name:'departmentNumber'
        }, {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>部门名称',
            name:'departmentName'
        },
        {
            xtype: 'textfield',
            fieldLabel: '<span style="color:red;">*</span>部门简介',
            name:'departmentIntroduction'
        }, /*{
            xtype: 'textfield',
            fieldLabel: '状态',
            name:'state'
        },*/ {
            xtype: 'datefield',
            fieldLabel: '<span style="color:red;">*</span>录入时间',
            name:'createTime',
            format: 'Y/m/d H:i:s'
        }, /*{
            xtype: 'textfield',
            fieldLabel: '审核状态',
            name:'checkStatus'
        }, */{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note'
        }
	]
    }],
    buttons:  [{
        xtype: 'button',
        text: 'Submit',
        handler: 'addSubmitButton'//预留提交事件，在ViewController中实现。
    },{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]

});
