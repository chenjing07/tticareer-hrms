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
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'applicationName',text: 'Application Name'},
	           {xtype: 'gridcolumn',cls:'content-column',width:120,dataIndex: 'expectedPosition',text: 'Expected Position'},
	           {xtype: 'gridcolumn',cls:'content-column',width: 160,dataIndex: 'idCardNumber',text: 'Id Card Number',hidden:true},
	           {xtype: 'gridcolumn',cls: 'content-column',width: 160,dataIndex: 'idCardPicture',text: 'Id Card Picture',hidden:true},
		    {xtype: 'datecolumn',cls: 'content-column',dataIndex: 'birthday',text: 'Birthday',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'gender',text: 'Gender',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'nation',text: 'Nation',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'nativePlace',text: 'Native Place',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'registeredAddress',text: 'Registered Address',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'houseAddress',text: 'House Address',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'politicalStatus',text: 'Political Status',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'maritalStatus',text: 'Marital Status',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'phoneNumber',text: 'Phone Number',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'email',text: 'Email',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'qq',text: 'QQ',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'education',text: 'Education',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'academicDegree',text: 'Academic Degree',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'major',text: 'Major',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'tie',text: 'Tie',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'graduatedSchool',text: 'Graduated School',hidden:true},
		    {xtype: 'datecolumn',cls: 'content-column',width: 160,dataIndex: 'graduatedTime',text: 'Graduated Time',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'awardsReceived',text: 'Awards Received',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'languageLevel',text: 'Language Level',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'workExperience',text: 'Work Experience',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column',width:120,dataIndex: 'hobbies',text: 'Hobbies',hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column',width:120,dataIndex: 'selfEvaluation',text: 'Self Evaluation',hidden:true},
	           {xtype: 'gridcolumn',cls: 'content-column',width:120,dataIndex: 'state',text: 'State'},
		    {xtype: 'datecolumn',cls: 'content-column', width:160,dataIndex: 'createTime',text: 'Create Time',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		    {xtype: 'gridcolumn',cls: 'content-column', width:120,dataIndex: 'note',text: 'Note'},
                  {xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
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
