/* Generated By:JavaCC: Do not edit this line. NolifeParserTokenManager.java */
package parser;
import ast.*;
import visitor.*;

/** Token Manager. */
public class NolifeParserTokenManager implements NolifeParserConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x3fffffc0L) != 0L)
         {
            jjmatchedKind = 52;
            return 4;
         }
         return -1;
      case 1:
         if ((active0 & 0x3fe6f7c0L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 1;
            return 4;
         }
         if ((active0 & 0x190800L) != 0L)
            return 4;
         return -1;
      case 2:
         if ((active0 & 0x3be2d700L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 2;
            return 4;
         }
         if ((active0 & 0x40420c0L) != 0L)
            return 4;
         return -1;
      case 3:
         if ((active0 & 0x22801000L) != 0L)
            return 4;
         if ((active0 & 0x1962c700L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 3;
            return 4;
         }
         return -1;
      case 4:
         if ((active0 & 0x18004300L) != 0L)
            return 4;
         if ((active0 & 0x1628400L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 4;
            return 4;
         }
         return -1;
      case 5:
         if ((active0 & 0x1000000L) != 0L)
            return 4;
         if ((active0 & 0x628400L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 5;
            return 4;
         }
         return -1;
      case 6:
         if ((active0 & 0x420000L) != 0L)
            return 4;
         if ((active0 & 0x208400L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 6;
            return 4;
         }
         return -1;
      case 7:
         if ((active0 & 0x8000L) != 0L)
            return 4;
         if ((active0 & 0x200400L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 7;
            return 4;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 40:
         return jjStopAtPos(0, 42);
      case 41:
         return jjStopAtPos(0, 43);
      case 42:
         return jjStopAtPos(0, 47);
      case 43:
         return jjStopAtPos(0, 45);
      case 44:
         return jjStopAtPos(0, 39);
      case 45:
         return jjStopAtPos(0, 46);
      case 46:
         return jjStopAtPos(0, 44);
      case 58:
         jjmatchedKind = 37;
         return jjMoveStringLiteralDfa1_0(0x1000000000L);
      case 59:
         return jjStopAtPos(0, 38);
      case 60:
         jjmatchedKind = 31;
         return jjMoveStringLiteralDfa1_0(0x840000000L);
      case 61:
         return jjStopAtPos(0, 34);
      case 62:
         jjmatchedKind = 33;
         return jjMoveStringLiteralDfa1_0(0x100000000L);
      case 65:
         return jjMoveStringLiteralDfa1_0(0x180L);
      case 66:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 67:
         return jjMoveStringLiteralDfa1_0(0x20000400L);
      case 68:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 69:
         return jjMoveStringLiteralDfa1_0(0x3000L);
      case 70:
         return jjMoveStringLiteralDfa1_0(0xc000L);
      case 73:
         return jjMoveStringLiteralDfa1_0(0x30000L);
      case 77:
         return jjMoveStringLiteralDfa1_0(0x40L);
      case 78:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 79:
         return jjMoveStringLiteralDfa1_0(0x180000L);
      case 80:
         return jjMoveStringLiteralDfa1_0(0x600000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x1800000L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x2000000L);
      case 86:
         return jjMoveStringLiteralDfa1_0(0x4000000L);
      case 87:
         return jjMoveStringLiteralDfa1_0(0x18000000L);
      case 91:
         return jjStopAtPos(0, 40);
      case 93:
         return jjStopAtPos(0, 41);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 61:
         if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         else if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(1, 32);
         else if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(1, 36);
         break;
      case 62:
         if ((active0 & 0x800000000L) != 0L)
            return jjStopAtPos(1, 35);
         break;
      case 65:
         return jjMoveStringLiteralDfa2_0(active0, 0x24000000L);
      case 69:
         return jjMoveStringLiteralDfa2_0(active0, 0x1800200L);
      case 70:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(1, 16, 4);
         else if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(1, 19, 4);
         break;
      case 72:
         return jjMoveStringLiteralDfa2_0(active0, 0xa000400L);
      case 76:
         return jjMoveStringLiteralDfa2_0(active0, 0x5000L);
      case 78:
         return jjMoveStringLiteralDfa2_0(active0, 0x22080L);
      case 79:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(1, 11, 4);
         return jjMoveStringLiteralDfa2_0(active0, 0x40040L);
      case 82:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(1, 20, 4);
         return jjMoveStringLiteralDfa2_0(active0, 0x10600100L);
      case 85:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa3_0(active0, 0x800400L);
      case 68:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(2, 6, 4);
         else if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(2, 7, 4);
         else if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(2, 13, 4);
         break;
      case 69:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000L);
      case 71:
         return jjMoveStringLiteralDfa3_0(active0, 0x200L);
      case 73:
         return jjMoveStringLiteralDfa3_0(active0, 0x18000000L);
      case 78:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000L);
      case 79:
         return jjMoveStringLiteralDfa3_0(active0, 0x604000L);
      case 82:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(2, 26, 4);
         return jjMoveStringLiteralDfa3_0(active0, 0x100L);
      case 83:
         return jjMoveStringLiteralDfa3_0(active0, 0x20001000L);
      case 84:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(2, 18, 4);
         return jjMoveStringLiteralDfa3_0(active0, 0x1020000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa4_0(active0, 0x4100L);
      case 67:
         return jjMoveStringLiteralDfa4_0(active0, 0x208000L);
      case 68:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(3, 23, 4);
         break;
      case 69:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(3, 12, 4);
         else if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(3, 29, 4);
         return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
      case 71:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000L);
      case 73:
         return jjMoveStringLiteralDfa4_0(active0, 0x200L);
      case 76:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000L);
      case 78:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(3, 25, 4);
         break;
      case 82:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      case 84:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
      case 85:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa5_0(active0, 0x400L);
      case 69:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(4, 27, 4);
         else if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(4, 28, 4);
         return jjMoveStringLiteralDfa5_0(active0, 0x200000L);
      case 71:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000L);
      case 78:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(4, 9, 4);
         break;
      case 82:
         return jjMoveStringLiteralDfa5_0(active0, 0x1400000L);
      case 84:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(4, 14, 4);
         return jjMoveStringLiteralDfa5_0(active0, 0x8000L);
      case 89:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(4, 8, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa6_0(active0, 0x400000L);
      case 67:
         return jjMoveStringLiteralDfa6_0(active0, 0x400L);
      case 68:
         return jjMoveStringLiteralDfa6_0(active0, 0x200000L);
      case 69:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000L);
      case 73:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000L);
      case 78:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(5, 24, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 77:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(6, 22, 4);
         break;
      case 79:
         return jjMoveStringLiteralDfa7_0(active0, 0x8000L);
      case 82:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(6, 17, 4);
         break;
      case 84:
         return jjMoveStringLiteralDfa7_0(active0, 0x400L);
      case 85:
         return jjMoveStringLiteralDfa7_0(active0, 0x200000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 69:
         return jjMoveStringLiteralDfa8_0(active0, 0x400L);
      case 78:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(7, 15, 4);
         break;
      case 82:
         return jjMoveStringLiteralDfa8_0(active0, 0x200000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 69:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(8, 21, 4);
         break;
      case 82:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(8, 10, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 23;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 55)
                        kind = 55;
                     jjCheckNAddStates(0, 3);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 55)
                        kind = 55;
                     jjCheckNAddTwoStates(12, 17);
                  }
                  else if (curChar == 39)
                     jjAddStates(4, 5);
                  break;
               case 1:
                  jjAddStates(6, 7);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 52)
                     kind = 52;
                  jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 5:
                  if (curChar == 39)
                     jjAddStates(4, 5);
                  break;
               case 6:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 7:
                  if (curChar == 39 && kind > 48)
                     kind = 48;
                  break;
               case 8:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     jjCheckNAdd(9);
                  break;
               case 9:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(9, 10);
                  break;
               case 10:
                  if (curChar == 39 && kind > 49)
                     kind = 49;
                  break;
               case 11:
                  if (curChar != 48)
                     break;
                  if (kind > 55)
                     kind = 55;
                  jjCheckNAddTwoStates(12, 17);
                  break;
               case 12:
                  if (curChar == 46)
                     jjCheckNAdd(13);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 54)
                     kind = 54;
                  jjCheckNAddTwoStates(13, 14);
                  break;
               case 15:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(16);
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 54)
                     kind = 54;
                  jjCheckNAdd(16);
                  break;
               case 18:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(19);
                  break;
               case 19:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 54)
                     kind = 54;
                  jjCheckNAdd(19);
                  break;
               case 20:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 55)
                     kind = 55;
                  jjCheckNAddStates(0, 3);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(8, 10);
                  break;
               case 22:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 55)
                     kind = 55;
                  jjCheckNAdd(22);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 52)
                        kind = 52;
                     jjCheckNAdd(4);
                  }
                  else if (curChar == 123)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 1:
                  if ((0xdfffffffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 2:
                  if (curChar == 125 && kind > 5)
                     kind = 5;
                  break;
               case 3:
               case 4:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 52)
                     kind = 52;
                  jjCheckNAdd(4);
                  break;
               case 6:
                  jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 8:
                  jjCheckNAdd(9);
                  break;
               case 9:
                  jjCheckNAddTwoStates(9, 10);
                  break;
               case 14:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(11, 12);
                  break;
               case 17:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(13, 14);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(6, 7);
                  break;
               case 6:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 8:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAdd(9);
                  break;
               case 9:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(9, 10);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 23 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   21, 12, 17, 22, 6, 8, 1, 2, 21, 12, 17, 15, 16, 18, 19, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, "\115\117\104", "\101\116\104", 
"\101\122\122\101\131", "\102\105\107\111\116", "\103\110\101\122\101\103\124\105\122", "\104\117", 
"\105\114\123\105", "\105\116\104", "\106\114\117\101\124", "\106\125\116\103\124\111\117\116", 
"\111\106", "\111\116\124\105\107\105\122", "\116\117\124", "\117\106", "\117\122", 
"\120\122\117\103\105\104\125\122\105", "\120\122\117\107\122\101\115", "\122\105\101\104", 
"\122\105\124\125\122\116", "\124\110\105\116", "\126\101\122", "\127\110\111\114\105", 
"\127\122\111\124\105", "\103\101\123\105", "\74\75", "\74", "\76\75", "\76", "\75", "\74\76", 
"\72\75", "\72", "\73", "\54", "\133", "\135", "\50", "\51", "\56", "\53", "\55", "\52", 
null, null, null, null, null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0xd3ffffffffffc1L, 
};
static final long[] jjtoSkip = {
   0x3eL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[23];
static private final int[] jjstateSet = new int[46];
static protected char curChar;
/** Constructor. */
public NolifeParserTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public NolifeParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 23; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
