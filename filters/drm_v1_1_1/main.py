#!/usr/bin/python

def run(sequence = '', filename = ''):
    print 'drm_v1_1_1 run >>>>>>>>>>>>>>>>>>>>> '
    print 'sequence:' + str(sequence) 
    print 'filename:' + str(filename)
    
    return {'sequence' : sequence , 'filename' : filename , 'drm' : 0}