#!/usr/bin/python

'''
 @LPG-INPIN-PARAM:0,packagingtoken,string
            @LPG-INPIN-PARAM:1,chname,string
            @LPG-INPIN-PARAM:2,bandwidth,string
            @LPG-INPIN-PARAM:3,streamindex,string
            @LPG-INPIN-PARAM:4,filename,string
            @LPG-INPIN-PARAM:5,squence,string
'''
def run(packagingtoken = '', chname = '' , bandwidth = '' , streamindex = '' , filename = '' , sequence = ''):
    print 'source_v1_1_1 run >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>' 
    
    print 'packagingtoken = ' + str(packagingtoken)
    print 'chname = ' + str(chname)
    print 'bandwidth = ' + str(bandwidth)
    print 'streamindex = ' + str(streamindex)
    print 'filename = ' + str(filename)
    print 'squence = ' + str(sequence)
    
    return {'sequence' : sequence , 'filename' : filename}