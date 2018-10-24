Ext.define('Admin.view.resume.ResumePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'resumePanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.grid.column.RowNumberer',
        'Ext.grid.column.Date'
    ],
    //controller: 'searchresults',
   // viewModel: {type: 'orderViewModel'},
    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: 'Resume Grid Results',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{resumeLists}',
            scrollable: false,
            columns: [
	           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
	           {xtype: 'gridcolumn',cls:'content-column',width:100,dataIndex: 'applicationName',text: '应聘人姓名'},
	           {xtype: 'gridcolumn',cls:'content-column',width:100,dataIndex: 'expectedPosition',text: '期望的职位'},
	           {xtype: 'gridcolumn',cls:'content-column',width: 160,dataIndex: 'idCardNumber',text: '身份证号',hidden:true},
	           {xtype: 'gridcolumn',cls: 'content-column',width: 160,dataIndex: 'idCardPicture',text: '身份证图片存放地址',hidden:true},
		    {xtype: 'datecolumn',cls: 'content-column',width:100,dataIndex: 'birthday',text: '出生年月',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'gender',text: '性别'},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'nation',text: '民族',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'nativePlace',text: '籍贯',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'registeredAddress',text: '户口地址',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'houseAddress',text: '家庭地址',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'politicalStatus',text: '政治面貌',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'maritalStatus',text: '婚姻状况',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'phoneNumber',text: '手机号码'},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'email',text: '邮箱',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'qq',text: 'QQ',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'education',text: '学历',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'academicDegree',text: '学位',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'major',text: '专业'},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'tie',text: '系别',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'graduatedSchool',text: '毕业学校',hidden:true},
		    {xtype: 'datecolumn',cls: 'content-column',width: 120,dataIndex: 'graduatedTime',text: '毕业时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'awardsReceived',text: '获得得奖项',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'languageLevel',text: '语言水平',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'workExperience',text: '工作经验',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column',width:100,dataIndex: 'hobbies',text: '兴趣爱好',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column',width:100,dataIndex: 'selfEvaluation',text: '自我评价',hidden:true},
	           {xtype: 'gridcolumn',cls: 'content-column',width:100,dataIndex: 'state',text: '状态'},
		    {xtype: 'datecolumn',cls: 'content-column', width:120,dataIndex: 'createTime',text: '录入时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		    {xtype: 'gridcolumn',cls: 'content-column', width:100,dataIndex: 'note',text: '备注',hidden:true},
                  {xtype: 'actioncolumn',cls: 'content-column', width: 160,text: 'Actions',tooltip: 'edit ',
                    items: [
                        {xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditResumeWindow'},
                        {xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
                        {xtype: 'button',iconCls: 'x-fa fa-ban',handler: 'onDisableButton'}
                    ]
                }
            ],
            tbar: [{ 
		                    xtype: 'combobox',
		                    reference:'searchFieldName',
		                    hideLabel: true, 
		                    store:Ext.create("Ext.data.Store", {
						    fields: ["name", "value"],
						    data: [
						      	{ name: '应聘人姓名', value: 'applicationName' },
						              { name: '状态', value: 'state' },
						              { name: '创建时间', value: 'createTime' }
						    ]
						}),     
		                    displayField: 'name',
		                    valueField:'value',
	           		      value:'applicationName',
	           		      editable: false,
		                    queryMode: 'local',
		                    triggerAction: 'all',
		                    emptyText: 'Select a state...',
		                    width: 135,
		                    listeners:{
						select: 'searchComboboxSelectChuang'
				}
		                },'-', {
		                     xtype:'textfield',
		                     reference:'searchFieldValue',
            			 	name:'resumePanelSearchField'
		                } ,'-', {
		                        xtype:'datefield',            
	            			  reference:'searchDateFieldValue1',
	            		 	  hidden :true,
	            			  name:'resumePanelSearchDateField1',
	            			 format: 'Y/m/d H:i:s'
		                },'-', {
		                       xtype:'datefield',            
	            			  reference:'searchDateFieldValue2',
	            		 	  hidden :true,
	            			  name:'resumePanelSearchDateField2',
	            			  format: 'Y/m/d H:i:s'
		                },'-',{
				        text: 'Search',
				        iconCls: 'fa fa-search',
				        handler: 'quickSearch'
				    },'-',{
				        text: 'Search More',
				        iconCls: 'fa fa-search-plus',
				        handler: 'openResumeSearchWindow'	
				    },'->',{
				        text: 'Add',
				        tooltip: 'Add a new row',
				        iconCls: 'fa fa-plus',
				        handler: 'openResumeAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'resumeGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{resumeLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  			this.down('#resumeGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
