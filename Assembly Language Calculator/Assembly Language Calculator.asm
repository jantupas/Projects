.model small
.stack
.data
	msg  db "1-Add $"
	msgb db "2-Subtract $"
	msgc db "3-Multiply $"
        msgd db "4-Divide $"
	msge db "5-Exit $"
	ent  db "Enter your choice: $"
	msg2 db "Enter first number: $"
	msg3 db "Enter second number: $"
	msg4 db "Input is not a number! $"
	msg5 db "Final Result : $"
	msg6 db "Continue?(y/n): $"
	msg7 db "Final Result : -$"
	clspace			db	0ah, 0dh, '$'
	.386 ; extend jump range
	del db 'DEL$'
	ex db 'EXIT$'
	row db 30
	var db 0
	nega db '-$'
.code
main	proc
	mov ax,@data
	mov ds,ax

start:	mov ah,6
	mov al,0
	mov bh,0100000b
	mov ch,0
	mov cl,0
	mov dh,24
	mov dl,79
	int 10h

	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,1
	mov cl,21
	mov dh,23
	mov dl,57
	int 10h


	mov ah,6
	mov al,0
	mov bh,01110000b
	mov ch,2
	mov cl,22
	mov dh,8
	mov dl,56
	int 10h


	mov ah,6
	mov al,0
	mov bh,00110000b
	mov ch,10
	mov cl,22
	mov dh,22
	mov dl,56
	int 10h


	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,11
	mov cl,24
	mov dh,12
	mov dl,30
	int 10h


	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,11
	mov cl,32
	mov dh,12
	mov dl,38
	int 10h


	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,11
	mov cl,40
	mov dh,12
	mov dl,46
	int 10h

	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,11
	mov cl,48
	mov dh,12
	mov dl,54
	int 10h


	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,14
	mov cl,24
	mov dh,15
	mov dl,30
	int 10h


	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,14
	mov cl,32
	mov dh,15
	mov dl,38
	int 10h


	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,14
	mov cl,40
	mov dh,15
	mov dl,46
	int 10h

	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,14
	mov cl,48
	mov dh,15
	mov dl,54
	int 10h

	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,17
	mov cl,24
	mov dh,18
	mov dl,30
	int 10h


	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,17
	mov cl,32
	mov dh,18
	mov dl,38
	int 10h


	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,17
	mov cl,40
	mov dh,18
	mov dl,46
	int 10h

	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,17
	mov cl,48
	mov dh,18
	mov dl,54
	int 10h

	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,20
	mov cl,24
	mov dh,21
	mov dl,30
	int 10h

	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,20
	mov cl,32
	mov dh,21
	mov dl,38
	int 10h

	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,20
	mov cl,40
	mov dh,21
	mov dl,46
	int 10h

	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,20
	mov cl,48
	mov dh,21
	mov dl,54
	int 10h

	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,17
	mov cl,48
	mov dh,18
	mov dl,54
	int 10h
	mov ah,6
	mov al,0
	mov bh,01010000b
	mov ch,17
	mov cl,48
	mov dh,18
	mov dl,54
	int 10h


	mov ah,2
	mov bh,0
	mov dh,12
	mov dl,27
	int 10h

	mov ah,2
	mov dl,'+'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,12
	mov dl,35
	int 10h

	mov ah,2
	mov dl,'-'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,12
	mov dl,43
	int 10h

	mov ah,2
	mov dl,'*'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,12
	mov dl,51
	int 10h

	mov ah,2
	mov dl,'/'

	int 21h
	mov ah,2
	mov bh,0
	mov dh,15
	mov dl,27
	int 10h

	mov ah,2
	mov dl,'1'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,15
	mov dl,35
	int 10h

	mov ah,2
	mov dl,'2'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,15
	mov dl,43
	int 10h

	mov ah,2
	mov dl,'3'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,15
	mov dl,50
	int 10h

	mov ah,9
	mov dx,offset del
	int 21h

	mov ah,2
	mov bh,0
	mov dh,18
	mov dl,27
	int 10h

	mov ah,2
	mov dl,'4'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,18
	mov dl,35
	int 10h

	mov ah,2
	mov dl,'5'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,18
	mov dl,43
	int 10h

	mov ah,2
	mov dl,'6'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,18
	mov dl,49
	int 10h

	mov ah,9
	mov dx,offset ex
	int 21h

	mov ah,2
	mov bh,0
	mov dh,21
	mov dl,27
	int 10h

	mov ah,2
	mov dl,'7'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,21
	mov dl,35
	int 10h

	mov ah,2
	mov dl,'8'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,21
	mov dl,43
	int 10h

	mov ah,2
	mov dl,'9'
	int 21h

	mov ah,2
	mov bh,0
	mov dh,21
	mov dl,51
	int 10h

	mov ah,2
	mov dl,'0'
	int 21h

		
        mov ah, 2					 
	mov bh, 0
	mov dh, 3 
	mov dl, 5
	int 10h

	mov ah,9
        mov dx, offset msg 
        int 21h

        mov ah, 2					 
	mov bh, 0
	mov dh, 4 
	mov dl, 5
	int 10h

	mov ah,9
        mov dx, offset msgb
        int 21h

        mov ah, 2					 
	mov bh, 0
	mov dh, 5 
	mov dl, 5
	int 10h

	mov ah,9
        mov dx, offset msgc
        int 21h

        mov ah, 2					 
	mov bh, 0
	mov dh, 6
	mov dl, 5
	int 10h

	mov ah,9
        mov dx, offset msgd
        int 21h

        mov ah, 2					 
	mov bh, 0
	mov dh, 7
	mov dl, 5
	int 10h

	mov ah,9
        mov dx, offset msge
        int 21h

	mov ah, 2					 
	mov bh, 0
	mov dh, 3
	mov dl, 23
	int 10h
	mov ah,9
        mov dx, offset ent
        int 21h
        mov ah,1                       
        int 21h  ;read input for operation to use
        cmp al,31h ;compare if operation is add
        je Addn
        cmp al,32h ;compare if operation is subtract
        je subn
        cmp al,33h ;compare if operation is multiply
        je muln
        cmp al,34h ;compare if operation is divide
        je division
	cmp al,35h ;compare if operating is exit
	je exit
	mov ah, 2					 
	mov bh, 0
	mov dh, 4
	mov dl, 23
	int 10h
	mov ah,9
	mov dx, offset msg4
	int 21h
        jmp start
        
Addn:  	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 4
	    mov dl, 23
	    int 10h
	    mov ah,9 
            mov dx, offset msg2  ;display add message
            int 21h
            mov cx,0	
            call inputNum  ;call input procedure to take in input
            push dx
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 5
	    mov dl, 23
	    int 10h
            mov ah,9
            mov dx, offset msg3
            int 21h 
            mov cx,0
            call inputNum2 ;call input procedure to take 2nd input
            pop bx
	    cmp var,1
	    je addNega1
	    cmp var,3
            je addNega2
            add dx,bx
            push dx 
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
	    cmp var,2
            je omsg7
	    jmp omsg5

addNega1:   cmp bx,dx
            jg	addNega1a
	    cmp bx,dx
            jle  addNega1b

addNega1a:  sub bx,dx
	    mov dx,bx
            push dx 
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
            jmp omsg7

addNega1b:  sub dx,bx
            push dx 
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
            jmp omsg5

addNega2:   cmp bx,dx
            jge	addNega2a
	    cmp bx,dx
            jl  addNega2b

addNega2a:  sub bx,dx
	    mov dx,bx
            push dx 
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
            jmp omsg5

addNega2b:  sub dx,bx
            push dx 
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
            jmp omsg7


       
Muln:       mov ah, 2					 
	    mov bh, 0
	    mov dh, 4
	    mov dl, 23
	    int 10h
	    mov ah,09h
            mov dx, offset msg2 ;display multiply message
            int 21h
            mov cx,0
            call inputNum ;call input procedure to take in input
            push dx
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 5
	    mov dl, 23
	    int 10h
            mov ah,9
            mov dx, offset msg3
            int 21h 
            mov cx,0
            call inputNum2 ;call input procedure to take 2nd input
            pop bx
            mov ax,dx
            mul bx 
            mov dx,ax
            push dx 
	    push ax
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h 
            pop ax
	    cmp ax,0
            je omsg5
	    cmp var,1
	    je omsg7
	    cmp var,3
	    je omsg7
	    cmp var,2
	    je omsg5
	    jmp omsg5

division:   jmp divn
Subn:       mov ah, 2					 
	    mov bh, 0
	    mov dh, 4
	    mov dl, 23
	    int 10h
	    mov ah,09h
            mov dx, offset msg2 ;display subtract message
            int 21h
            mov cx,0
            call inputNum ;call input procedure to take in input
            push dx
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 5
	    mov dl, 23
	    int 10h
            mov ah,9
            mov dx, offset msg3
            int 21h 
            mov cx,0
            call inputNum2 ;call input procedure to take 2nd input
            pop bx
            cmp var,1
            je	subNega1
            cmp var,3
            je	subNega2
            cmp var,2
            je	subNega3
	    cmp bx,dx
	    jge Pos
	    cmp bx,dx
	    jl Ngtv

subNega1:   add dx,bx
            push dx 
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
            jmp omsg7

subNega2:   add dx,bx
            push dx 
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
            jmp omsg5

subNega3:   cmp bx,dx
	    jg  subNega3a
	    cmp bx,dx
            jle  subNega3b


subNega3a:  sub bx,dx
	    mov dx,bx
            push dx 
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
            jmp omsg7

subNega3b:  sub dx,bx
            push dx 
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
            jmp omsg5

			
Ngtv:	    sub dx,bx
	    mov bx,dx
	    push dx
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
	    mov ah,9
	    mov dx, offset msg7
	    int 21h
	    mov cx,1000
	    pop dx
	    call view
	    jmp repeat
			
Pos:        sub bx,dx
            mov dx,bx
            push dx 
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h
            mov ah,9
            mov dx, offset msg5
            int 21h
            mov cx,1000
            pop dx
            call view 
            jmp repeat

middle:     jmp start

Divn:       mov ah, 2					 
	    mov bh, 0
	    mov dh, 4
	    mov dl, 23
	    int 10h
	    mov ah,09h
            mov dx, offset msg2 ;display divide message
            int 21h
            mov cx,0
            call inputNum ;call input procedure to take in input
            push dx
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 5
	    mov dl, 23
	    int 10h
            mov ah,9
            mov dx, offset msg3
            int 21h 
            mov cx,0
            call inputNum2 ;call input procedure to take 2nd input
            pop bx
            mov ax,bx
            mov cx,dx
            mov dx,0
            mov bx,0
            div cx
            mov bx,dx
            mov dx,ax
            push bx 
            push dx
	    push ax
	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 6
	    mov dl, 23
	    int 10h 
            pop ax
	    cmp ax,0
            je omsg5
	    cmp var,1
	    je omsg7
	    cmp var,3
	    je omsg7
	    cmp var,2
	    je omsg5
	    jmp omsg5

omsg7:      mov var,0
            mov ah,9
            mov dx, offset msg7
            int 21h
            mov cx,1000
            pop dx
            call view 
            jmp repeat

omsg5:      mov var,0
            mov ah,9
            mov dx, offset msg5
            int 21h
            mov cx,1000
            pop dx
            call view 
            jmp repeat


repeat:	    mov ah, 2					 
	    mov bh, 0
	    mov dh, 7
	    mov dl, 23
	    int 10h
	    mov ah,9
            mov dx, offset msg6 
            int 21h
            mov ah,1                       
            int 21h  
            cmp al,59h					; 'y'
            je middle
	    cmp al,79h					; 'n'
	    je middle
	    jmp exit

inputNum:   mov ah,0
            int 16h ;read key entered   
            mov dx,0  
            mov bx,1 
            cmp al,0dh ;compare keypressed to enter 
            je formNum ;if keypressed is enter, input is done
	    cmp al,2dh
	    je negInput
            sub ax,30h ;convert input ascii code to decimal
            call viewNum ;call view procedure to show numbers inputted
            mov ah,0 ;
            push ax  
	    inc cx ;counter for the number of digits
            jmp inputNum ;to take in another digit if two digit input is desired 

inputNum2:  mov ah,0
            int 16h ;read key entered   
            mov dx,0  
            mov bx,1 
            cmp al,0dh ;compare keypressed to enter 
            je formNum ;if keypressed is enter, input is done
	    cmp al,2dh
	    je negInput2
            sub ax,30h ;convert input ascii code to decimal
            call viewNum ;call view procedure to show numbers inputted
            mov ah,0 ;
            push ax  
	    inc cx ;counter for the number of digits
            jmp inputNum2 ;to take in another digit if two digit input is desired        
   


formNum:    pop ax  ;forming the number by decimal base because input is taken separately
            push dx      
            mul bx 
            pop dx
            add dx,ax
            mov ax,bx       
            mov bx,10 
            push dx
            mul bx
            pop dx
            mov bx,ax
            dec cx
            cmp cx,0
            jne formNum
            ret   

view:  mov ax,dx ;show the final result
       mov dx,0
       div cx 
       call viewNum
       mov bx,dx 
       mov dx,0
       mov ax,cx 
       mov cx,10
       div cx
       mov dx,bx 
       mov cx,ax
       cmp ax,0
       jne View
       ret

viewNum:   push ax 
           push dx 
           mov dx,ax 
           add dl,30h ;add 30 to convert back to ascii 
           mov ah,2
           int 21h
           pop dx  
           pop ax
           ret

negInput: mov var,1
	  mov ah,9
	  mov dx,offset nega
	  int 21h
	  jmp inputNum

negInput2: cmp var,0
	  je negInput2a
	  jmp negInput2b


negInput2a: mov var,3
	  mov ah,9
	  mov dx,offset nega
	  int 21h
	  jmp inputNum2

negInput2b: mov var,2
	  mov ah,9
	  mov dx,offset nega
	  int 21h
	  jmp inputNum2
		
                
  
exit:	mov ah,9
		mov dx,offset clspace
		int 21h

		mov ah,4ch
		int 21h
main	endp
end	main