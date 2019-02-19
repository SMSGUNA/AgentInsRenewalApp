package com.example.ajay_saba.insurancerenewal

class Policy {
    var clientname:String?=null
    var policyno:String?=null
    var renewaldate:String?=null
    var vehicleno:String?=null

    constructor():this("","","","")
    constructor(clientname: String?, policyno: String?, renewaldate: String?, vehicleno: String?) {
        this.clientname = clientname
        this.policyno = policyno
        this.renewaldate = renewaldate
        this.vehicleno = vehicleno
    }

    //constructor(clientname:String?,policyno:String?,renewaldate:String?,vehicleno:String?)

}