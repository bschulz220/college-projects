# Due the Friday before Finals week.

#	// ASSEMBLY LANGUAGE PROGRAM
#	// Jim Cain edited by Ben Schulz
#	// CIS 2233
#
#	import java.io.*;
#	
#	public class CIS2233StarterCode3Java {
#	
#	public static void main (String [] args) throws IOException {
#	
#	BufferedReader kbd = new BufferedReader (new InputStreamReader (System.in));
#	int [] list = {5,7,4,6,3,8,2,9,0,20,21,29,22,28,23,27,24,26,25,30,31,39,32,38,33,37,34,36,35,10,11,19,12,18,13,17,14,16,15,1};
#	String prompt1 = "\nPlease enter an array element: ";
#	String prompt2 = "\nPlease enter a search target: ";
#	String space = " ";
#	String nfound = "\nThe target was not found.";
#	String found = "\nThe target was fount at array location ";
#	int t0 = 0;
#	int t1 = 0;
#	int t2 = 39;
#	int t3 = 39;
#	int t4;
#	int t5;
#	int t6;
#	int a0;
#	int v0;
#	// address calculation register t7
#	// base address of array register t8
#	// address calculation register t9
#	do {
#		System.out.print (prompt1);
#		v0 = Integer.parseInt(kbd.readLine());
#		list [t0] = v0;
#		t0 ++;
#	} while (t0 <= t2);
#	t0 = 0;
#	do {
#		t1 = 0;
#		do {
#			t4 = list [t1];
#			t5 = list [t1 + 1];
#			if (t4 > t5) {
#				list [t1 + 1] = t4;
#				list [t1] = t5;
#			}
#			t1 ++;
#		} while (t1 < t3);
#		t3 --;
#		t0 ++;
#	} while (t0 < t2);
#	t0 = 0;
#	do {
#		a0 = list [t0];
#		System.out.print (a0);
#		System.out.print (space);
#		t0 ++;
#	} while (t0 <= t2);
#	System.out.print (prompt2); //start MIPS here
#	t6 = Integer.parseInt(kbd.readLine());
#	t1 = 0;
#	t3 = 39;
#	t1 = RecLinSearch (list, t3, t1, t6);
#	if (t1 != -1) {
#		System.out.print (found);
#		System.out.print (t1);
#	} else {
#		System.out.print (nfound);
#	}
#	
#	}  // public static void main (String [] args) throws IOException {...
#	
#	public static int RecLinSearch (int [] list, int t3, int t1, int t6) {
#		if (t1 <= t3) {
#			if (list [t1] == t6) {
#				return t1;
#			} else {
#				return RecLinSearch (list, t3, t1 + 1, t6);
#			}
#		} else {
#			return -1;
#		}
#	}
#
#	}  // public class CIS2233Prog3StarterCode {...

		.data
list:		.word 0
		.word 1
		.word 2
		.word 3
		.word 4
		.word 5
		.word 6
		.word 7
		.word 8
		.word 9
		.word 10
		.word 11
		.word 12
		.word 13
		.word 14
		.word 15
		.word 16
		.word 17
		.word 18
		.word 19
		.word 20
		.word 21
		.word 22
		.word 23
		.word 24
		.word 25
		.word 26
		.word 27
		.word 28
		.word 29
		.word 30
		.word 31
		.word 32
		.word 33
		.word 34
		.word 35
		.word 36
		.word 37
		.word 38
		.word 39		# last array element
		.word -1			# not part of array
prompt1:	.asciiz "\nPlease enter an array element: "
prompt2:	.asciiz "\nPlease enter a search target: "
space:	.asciiz " "
nfound:	.asciiz "\nThe target was not found."
found:	.asciiz "\nThe target was found at array location "

		.text
		.globl main
main:		add $t0, $zero, $zero	# [main]
		add $t1, $zero, $zero	#
		addi $t2, $zero, 39	#
		addi $t3, $zero, 39	#
		add $t4, $zero, $zero	#
		add $t5, $zero, $zero	#
		add $t6, $zero, $zero	#
		add $t7, $zero, $zero	#
		la $t8, list

#With the read loop commented out, you can sort the garbage
#and search the garbage that I initialized the arrray with.
#I used the values 0 to 39; all are present, but in a 
#somewhat random order.

#read:	addi $v0, $zero, 4	# [read]
#		la $a0, prompt1		#
#		syscall
#		addi $v0, $zero, 5	#
#		syscall
#		sll $t7, $t0, 2		#
#		add $t9, $t8, $t7
#		sw $v0, 0($t9)
#		addi $t0, $t0, 1		#
#		ble $t0, $t2, read	#


#Array is pre-sorted.
#		add $t0, $zero, $zero	#
#outer:	add $t1, $zero, $zero	# [outer]
#inner:	sll $t7, $t1, 2		# [inner]
#		add $t9, $t8, $t7
#		lw $t4, 0($t9)
#		lw $t5, 4($t9)
#		ble $t4, $t5, skip	#
#		sw $t4, 4($t9)
#		sw $t5, 0($t9)
#skip:	addi $t1, $t1, 1		# [skip]
#		bne $t1, $t3, inner	#
#		addi $t3, $t3, -1		#
#		addi $t0, $t0, 1		#
#		bne $t0, $t2, outer	#



		add $t0, $zero, $zero	#
print:	addi $v0, $zero, 1	# [print]
		sll $t7, $t0, 2		#
		add $t9, $t8, $t7
		lw $a0, 0($t9)
		syscall
		addi $v0, $zero, 4	#
		la $a0, space		#
		syscall
		addi $t0, $t0, 1		#
		ble $t0, $t2, print	#

#	insert missing search code ---------------------------------------------------------------------------------	
		la $v0, 4
		la $a0, prompt2
		syscall					#	System.out.print (prompt2);
		li $v0, 5
		syscall
		add $t6, $zero, $v0		#	t6 = Integer.parseInt(kbd.readLine());
		add $t1, $zero, $zero	#	t1 = 0;
		addi $t3, $zero, 39		#	t3 = 39;
		
		jal search				#	t1 = RecLinSearch (list, t3, t1, t6);
		beq $t1, -1, fail		#	if (t1 != -1) {
		la $v0, 4
		la $a0, found
		syscall					#		System.out.print (found);
		la $v0, 1
		add $a0, $zero, $t1
		syscall					#		System.out.print (t1);
		j end
								#	} else {
fail:	la $v0, 4
		la $a0, nfound
		syscall					#		System.out.print (nfound);
								#	}
								#	
								#	}  // public static void main (String [] args) throws IOException {...
								#	
		j end
								#	public static int RecLinSearch (int [] list, int t3, int t1, int t6) {
search: addi $sp, $sp, -4		
		sw $ra, 4($sp)	
		bgt $t1, $t3, outerelse #		if (t1 <= t3) {
		add $t5, $t1, $zero		
		sll $t5, $t5, 2	#t5*4
		add $t9, $t8, $t5
		lw $t7, 0($t9)
		bne $t7, $t6, innerelse	#			if (list [t1] == t6) {
		j return				#				return t1;
innerelse:						#			} else {
		addi $t1, $t1, 1
		j search #jal search	#				return RecLinSearch (list, t3, t1 + 1, t6);
								#			}
outerelse:						#		} else {
		addi $t1, $zero, -1 	#			return -1;
		#j return				#		}
								#	}
		
return:	lw $ra, 4($sp)
		addi $sp, $sp, 4
		jr $ra
		
#---------------------------------------------------------------------------------------------------------------
end:	addi $v0, $zero, 10	#was already here
		syscall				#was already here
		
#	insert missing search function
