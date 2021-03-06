#	// ASSEMBLY LANGUAGE PROGRAM
#	// Jim Cain edited by Ben Schulz
#	// CIS 2233
#
#	import java.io.*;
#	
#	public class CIS2233StarterCode2Java {
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
#	} while (t0 <= t2);//main
#	t0 = 0;//begin missing code ------------------------------------------------------------------
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
#	} while (t0 < t2);//end missing code ---------------------------------------------------------
#	t0 = 0;
#	do {
#		a0 = list [t0];
#		System.out.print (a0);
#		System.out.print (space);
#		t0 ++;
#	} while (t0 <= t2);//print
#	
#	}  // public static void main (String [] args) throws IOException {...
#	
#	}  // public class CIS2233StarterCode2Java {...

		.data
list:	.word 5
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
main:	add $t0, $zero, $zero	# [main]
		add $t1, $zero, $zero	# t1 = 0
		addi $t2, $zero, 39		# t2 = 39
		addi $t3, $zero, 39		# t3 = 39
		add $t4, $zero, $zero	# t4 = 0
		add $t5, $zero, $zero	# t5 = 0
		add $t6, $zero, $zero	# t6 = 0 //never used, use it if you have to
		add $t7, $zero, $zero	# t7 = 0
		la $t8, list			#load address of list

#read:	addi $v0, $zero, 4	# [read] v0 = 4
#		la $a0, prompt1		# load address of prompt1
#		syscall
#		addi $v0, $zero, 5	# v0 = 5
#		syscall
#		sll $t7, $t0, 2		# t7 = t0 * 2^2 ?
#		add $t9, $t8, $t7	# t9 = t8 + t7
#		sw $v0, 0($t9)		# store word
#		addi $t0, $t0, 1	# t0++
#		ble $t0, $t2, read	# while (t0 <= t2) goto read

# add the code that is missing from right here ------------------------------------------------------
		add $t0, $zero, $zero	#	t0 = 0;
		la $a0, list
		sll $t3, $t3, 2 		#t3 *= 4?
		add $t3, $t3, $a0
sort:							#	do {
		add $t1, $zero, $zero	#		t1 = 0;
		add $t1, $t1, $a0
		
bubble: 						#		do {
		lw $t4, 0($t1)
		lw $t5, 4($t1)
		
		blt	$t4, $t5, else	#				if (t4 < t5) {
		sw $t4, 4($t1)			#					list [t1 + 1] = t4;
		sw $t5, 0($t1)			#					list [t1] = t5;
		
		
else:						#				}
		addi $t1, $t1, 4	#				t1 ++;
		
		slt $t6, $t1, $t3
		beq $t6, 1, bubble	#			} while (t1 < t3);
		
		addi $t3, $t3, -4	#			t3 --;
		addi $t0, $t0, 1	#			t0 ++;
		blt $t0, $t2, sort	#		} while (t0 < t2);//t0 < 39
#----------------------------------------------------------------------------------------------------

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

end:	addi $v0, $zero, 10	# [end]
		syscall
