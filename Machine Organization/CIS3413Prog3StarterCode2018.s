#	// ASSEMBLY LANGUAGE PROGRAM
#	// Jim Cain edited by Ben Schulz
#	// CIS 2233
#
#	import java.io.*;
#	
#	public class CIS2233StarterCode4Java {
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
#	// address calculation register t7
#	// base address of array register t8
#	// address calculation register t9
#	do {
#		System.out.print (prompt1);
#		list [t0] = Integer.parseInt(kbd.readLine());
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
#		t4 = list [t0];
#		System.out.print (t4);
#		System.out.print (space);
#		t0 ++;
#	} while (t0 <= t2);
#	System.out.print (prompt2);
#	t6 = Integer.parseInt(kbd.readLine());
#	t1 = 0;
#	t3 = 39;
#	do {
#		t5 = t1 + t3;
#		t5 = t5 / 2;
#		t4 = list [t5];
#		if (t4 == t6) {
#			System.out.print (found);
#			System.out.print (t5);
#			t1 = t3 + 1;
#		} else {
#			if (t4 < t6) {
#				t1 = t5 + 1;
#			} else {
#				t3 = t5 - 1;
#			}
#			if (t1 > t3) {
#				System.out.print (nfound);
#				t1 = t3 + 1;
#			}
#		}
#	} while (t1 <= t3);
#	
#	}  // public static void main (String [] args) throws IOException {...
#	
#	}  // public class CIS2233StarterCode4Java {...

		.data
list:		.word 5
		.word 7
		.word 4
		.word 6
		.word 3
		.word 8
		.word 2
		.word 9
		.word 0
		.word 30
		.word 31
		.word 39
		.word 32
		.word 38
		.word 33
		.word 37
		.word 34
		.word 36
		.word 35
		.word 20
		.word 21
		.word 29
		.word 22
		.word 28
		.word 23
		.word 27
		.word 24
		.word 26
		.word 25
		.word 10
		.word 11
		.word 19
		.word 12
		.word 18
		.word 13
		.word 17
		.word 14
		.word 16
		.word 15
		.word 1			# last array element
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
#and search the garbage that I initialized the array with.
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

		add $t0, $zero, $zero	#
outer:	add $t1, $zero, $zero	# [outer]
inner:	sll $t7, $t1, 2		# [inner]
		add $t9, $t8, $t7
		lw $t4, 0($t9)
		lw $t5, 4($t9)
		ble $t4, $t5, skip	#
		sw $t4, 4($t9)
		sw $t5, 0($t9)
skip:		addi $t1, $t1, 1		# [skip]
		bne $t1, $t3, inner	#
		addi $t3, $t3, -1		#
		addi $t0, $t0, 1		#
		bne $t0, $t2, outer	#

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

# add the code that is missing from right here -------------------------------------------------------------------
		la $a0, prompt2
		syscall					#	System.out.print (prompt2);
		li $v0, 5
		syscall
		add $t6, $zero, $v0		#	t6 = Integer.parseInt(kbd.readLine());
		add $t1, $zero, $zero 	#	t1 = 0;
		addi $t3, $zero, 39		#	t3 = 39;
		#sll $t3, $t3, 2 #quadruple t3
search:							#	do {
		add $t5, $t1, $t3		#		t5 = t1 + t3;
		
		sra $t5, $t5, 1 		#		t5 = t5 / 2;
		sll $t5, $t5, 2	#t5*4
		add $t9, $t5, $t8
		lw $t4, 0($t9)			#		t4 = list [t5];
		beq $t4, $t6, success	#		if (t4 == t6) { //target found

								#		} else {
		bge $t4, $t6, greater	#			if (t4 < t6) {
		sra $t5, $t5, 2
		addi $t1, $t5, 1		#				t1 = t5 + 1; //these two lines need to look at old t5, not quad t5
		j less
greater:						#			} else {
		sra $t5, $t5, 2
		addi $t3, $t5, -1		#				t3 = t5 - 1; //these two lines need to look at old t5, not quad t5
less:							#			}
		ble $t1, $t3, continue	#			if (t1 > t3) {
		li $v0, 4
		la $a0, nfound
		syscall					#				System.out.print (nfound);
		addi $t1, $t3, 1		#				t1 = t3 + 1;
								#			}
								#		}
		j continue 				#//else, skips the success part
success: 
		la $v0, 4
		la $a0, found
		syscall					#			System.out.print (found);
		sra $t5, $t5, 2 # t5/4
		la $v0, 1
		add $a0, $zero, $t5
		syscall 				#			System.out.print (t5);
		addi $t1, $t3, 1 		#			t1 = t3 + 1;
continue:
		ble $t1, $t3, search	#	} while (t1 <= t3);
#-----------------------------------------------------------------------------------------------------------------

end:	addi $v0, $zero, 10	# [end]
		syscall
